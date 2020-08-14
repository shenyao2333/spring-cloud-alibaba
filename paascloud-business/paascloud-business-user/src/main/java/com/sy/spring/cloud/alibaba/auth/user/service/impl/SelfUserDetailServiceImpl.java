package com.sy.spring.cloud.alibaba.auth.user.service.impl;

import com.sy.spring.cloud.alibaba.auth.user.domain.dto.AuthLoginDto;
import com.sy.spring.cloud.alibaba.auth.user.domain.dto.RegisterUserDto;
import com.sy.spring.cloud.alibaba.auth.user.domain.vo.UserLoginVo;
import com.sy.spring.cloud.alibaba.auth.user.domain.vo.UserVo;
import com.sy.spring.cloud.alibaba.auth.user.mapper.SelfUserDetailMapper;
import com.sy.spring.cloud.alibaba.auth.user.service.SelfUserDetailService;
import com.sy.spring.cloud.alibaba.auth.user.service.UserInfoService;
import com.sy.spring.cloud.alibaba.auth.user.surictiy.SelfUserDetails;
import com.sy.spring.cloud.alibaba.provider.basic.allocation.GeneralEnum;
import com.sy.spring.cloud.alibaba.provider.basic.domain.auth.UserInfo;
import com.sy.spring.cloud.alibaba.provider.basic.redis.RedisUtil;
import com.sy.spring.cloud.alibaba.provider.basic.service.YunSendPhoneMsg;
import com.sy.spring.cloud.alibaba.provider.basic.utils.JwtTokenUtil;
import com.sy.spring.cloud.alibaba.provider.basic.utils.SendEmailUtil;
import com.sy.spring.cloud.alibaba.provider.basic.utils.StringUtil;
import com.sy.spring.cloud.alibaba.provider.basic.web.ErrorEnum;
import com.sy.spring.cloud.alibaba.provider.basic.web.GrabException;
import com.sy.spring.cloud.alibaba.provider.basic.web.RespBean;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author ：sy
 * @date ：Created in 2020.3.29 21:27
 * @description:
 */
@Service
public class SelfUserDetailServiceImpl implements SelfUserDetailService {

    @Resource
    private SelfUserDetailMapper selfUserDetailMapper;

    @Resource
    private RedisUtil redisUtil;

    @Resource
    private UserInfoService userInfoService;


    @Override
    public SelfUserDetails userLogin(AuthLoginDto authLoginVo) {
        SelfUserDetails user =  selfUserDetailMapper.userLogin(authLoginVo);
        if (user!=null){

        }

        return user;
    }

    @Override
    public SelfUserDetails selectByUserName(String username) {
        return null;
    }

    @Override
    public UserLoginVo userLoginByCode(String mobile, String code) {
        Object reCode = redisUtil.get("loginCode" + mobile);
        if (reCode==null||!reCode.toString().equals(code)){
            throw new GrabException(ErrorEnum.CODE_ERR);
        }
        UserVo user =  userInfoService.selectByMobile(mobile);
        if (user==null){

            throw new GrabException(ErrorEnum.UNREGISTERED_EMAIL);
        }
        UserLoginVo userLoginVo = new UserLoginVo();
        userLoginVo.setValidTime(GeneralEnum.TOKEN_VALID.valueLong);
        userLoginVo.setUserVo(user);
        String token = JwtTokenUtil.createToken(user.getUserName());
        userLoginVo.setToken(token);
        redisUtil.set(token,user,GeneralEnum.TOKEN_VALID.valueLong);
        return userLoginVo;
    }

    @Override
    @Async
    public void getMobileCode(String mobile) {
        String ranNum = StringUtil.getRanNum(4);
        boolean code = YunSendPhoneMsg.getCode(GeneralEnum.YUN_CODE_TEMPLATEID.toString(), mobile, ranNum);
        if (!code){
            throw new GrabException(RespBean.CodeStatus.EXTERN,"获取验证码错误");
        }
        redisUtil.set("mobileCode-"+mobile,ranNum,GeneralEnum.CODE_VALID.valueLong);
    }

    @Override
    public UserLoginVo register(RegisterUserDto userDto) {
        String email = userDto.getEmail();
        String cheMobiles = userInfoService.checkAcc(userDto.getMobile(), "", "");
        if(cheMobiles!=null){
            throw new GrabException(RespBean.CodeStatus.REQUEST_PARAM,"该手机号已被注册使用");
        }
        String cheEmail = userInfoService.checkAcc("", userDto.getEmail(), "");
        if (cheEmail!=null){
            throw new GrabException(RespBean.CodeStatus.REQUEST_PARAM,"该邮箱已被注册使用");
        }
        Object o = redisUtil.get("emailCode-" + email);
        if (o==null||!o.toString().equals(userDto.getEmailCode())){
            throw new GrabException(RespBean.CodeStatus.REQUEST_PARAM,"邮箱验证码错误");
        }

        UserInfo userInfo = new UserInfo();
        userInfo.setMobile(userDto.getMobile());
        userInfo.setEmail(userDto.getEmail());
        userInfo.setCreateTime(new Date());
        String userName;
        if (redisUtil.get("defaultNameNum")!=null){
            long defaultNameNum = redisUtil.incr("defaultNameNum", 1);
            userName="超超"+repairLength(defaultNameNum)+"号";
        }else {
            redisUtil.set("defaultNameNum", 1);
            userName="超超0001号";
        }
        userInfo.setUserName(userName);
        userInfo.setPassword(new BCryptPasswordEncoder().encode(userDto.getPassword()));
        userInfoService.insertSelective(userInfo);
        userInfo.setPassword(null);
        UserLoginVo userLoginVo =  new UserLoginVo();
        String token = JwtTokenUtil.createToken(userName);
        userLoginVo.setToken(token);
        userLoginVo.setValidTime(GeneralEnum.TOKEN_VALID.valueLong);
        UserVo userVo = new UserVo();
        userVo.setUserName(userName);
        userVo.setEmail(email);
        userVo.setId(userInfo.getId());
        userLoginVo.setUserVo(userVo);
        redisUtil.set(token,userVo,GeneralEnum.TOKEN_VALID.valueLong);
        return userLoginVo;
    }


    @Override
    @Async
    public void getEmailCode(String email) {
        String ranNum = StringUtil.getRanNum(4);
        SendEmailUtil.doSendRegister(email, ranNum);
        redisUtil.set("emailCode-"+email,ranNum,GeneralEnum.CODE_VALID.valueLong);
    }


    public String repairLength(Long l){
        int length = (l + "").length();
        StringBuffer sb = new StringBuffer();
        for (int i= length ;i<4;i++){
            sb.append("0");
        }
        return sb.append(l).toString();
    }



}
