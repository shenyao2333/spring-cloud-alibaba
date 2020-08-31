package com.sy.spring.cloud.alibaba.business.user.service.impl;

import com.sy.spring.cloud.alibaba.business.user.domain.dto.AuthLoginDto;
import com.sy.spring.cloud.alibaba.business.user.domain.dto.UpdPasswordDto;
import com.sy.spring.cloud.alibaba.business.user.domain.dto.UpdUserInfoDto;
import com.sy.spring.cloud.alibaba.business.user.domain.vo.UserLoginVo;
import com.sy.spring.cloud.alibaba.business.user.domain.vo.UserVo;
import com.sy.spring.cloud.alibaba.provider.basic.allocation.GeneralEnum;
import com.sy.spring.cloud.alibaba.provider.basic.redis.RedisUtil;
import com.sy.spring.cloud.alibaba.provider.basic.utils.JwtTokenUtil;
import com.sy.spring.cloud.alibaba.provider.basic.web.ErrorEnum;
import com.sy.spring.cloud.alibaba.provider.basic.web.GrabException;
import com.sy.spring.cloud.alibaba.provider.basic.web.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.sy.spring.cloud.alibaba.provider.basic.domain.auth.UserInfo;
import com.sy.spring.cloud.alibaba.business.user.mapper.UserInfoMapper;
import com.sy.spring.cloud.alibaba.business.user.service.UserInfoService;

import java.util.Date;

@Service
@Slf4j
public class UserInfoServiceImpl implements UserInfoService{

    @Resource
    private UserInfoMapper userInfoMapper;

    @Resource
    private RedisUtil redisUtil;




    @Override
    public int insert(UserInfo record) {
        return userInfoMapper.insert(record);
    }

    @Override
    public int insertSelective(UserInfo record) {
        return userInfoMapper.insertSelective(record);
    }

    @Override
    public UserInfo selectByPrimaryKey(Long id) {
        return userInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(UserInfo record) {
        return userInfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(UserInfo record) {
        return userInfoMapper.updateByPrimaryKey(record);
    }



    @Override
    public UserLoginVo userLoginByEvidence(AuthLoginDto authLoginVo) {
        if ("".equals(authLoginVo.getEvidence())|| "".equals(authLoginVo.getPassword())){
            throw new GrabException(R.CodeStatus.REQUEST,"请求输入帐号或密码");
        }

        UserInfo user = userInfoMapper.userLoginByEvidence(authLoginVo.getEvidence());
        BCryptPasswordEncoder bcryptPasswordEncoder =new BCryptPasswordEncoder();

        if (user!=null){
            if (!bcryptPasswordEncoder .matches(authLoginVo.getPassword(),user.getPassword())){
                throw new GrabException(ErrorEnum.LONG_ERR);
            }
            UserLoginVo userLoginVo = new UserLoginVo();
            UserVo userVo = new UserVo();
            BeanUtils.copyProperties(user,userVo);
            String token = JwtTokenUtil.createToken(userVo.getUserName());
            userLoginVo.setToken(token);
            userLoginVo.setUserVo(userVo);
            userLoginVo.setValidTime(GeneralEnum.TOKEN_VALID.valueLong);
            redisUtil.set(token,userVo,GeneralEnum.TOKEN_VALID.valueLong);
            return userLoginVo;
        }

        throw new GrabException(ErrorEnum.LONG_ERR);

    }

    @Override
    public UserVo selectByMobile(String mobile) {
        return  userInfoMapper.selectByMobile(mobile);
    }

    @Override
    public UserVo selectByEmail(String email) {
        return  userInfoMapper.selectByEmail(email);
    }

    @Override
    public String checkAcc(String mobile, String email, String qq) {
        return userInfoMapper.checkAcc(mobile,email,qq);
    }



    @Override
    public int updUserByDto(UpdUserInfoDto userInfoDto) {
        UserInfo userInfo = new UserInfo();
        BeanUtils.copyProperties(userInfoDto,userInfo);
        userInfo.setUpdateTime(new Date());

        return updateByPrimaryKeySelective(userInfo);
    }

    @Override
    public int updPasswordByDto(UpdPasswordDto passwordDto) {
        UserInfo userInfo = userInfoMapper.userLoginByEvidence(passwordDto.getEmail());
        if (userInfo==null){
            throw new GrabException(3001,"该账户不存在");
        }
        BCryptPasswordEncoder bcryptPasswordEncoder =new BCryptPasswordEncoder();

        if (!bcryptPasswordEncoder .matches(passwordDto.getOldPassword(),userInfo.getPassword())){
            throw new GrabException(3002,"旧密码错误");
        }
        UserInfo updInfo = new UserInfo();
        updInfo.setId(userInfo.getId());
        updInfo.setPassword(passwordDto.getNewPassword());
        return updateByPrimaryKeySelective(updInfo);

    }


}
