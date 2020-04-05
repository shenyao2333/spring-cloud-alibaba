package com.sy.spring.cloud.alibaba.auth.user.service.impl;

import com.sy.spring.cloud.alibaba.auth.user.domain.dto.AuthLoginDto;
import com.sy.spring.cloud.alibaba.auth.user.domain.vo.UserLoginVo;
import com.sy.spring.cloud.alibaba.auth.user.domain.vo.UserVo;
import com.sy.spring.cloud.alibaba.module.allocation.GeneralEnum;
import com.sy.spring.cloud.alibaba.module.redis.RedisUtil;
import com.sy.spring.cloud.alibaba.module.utils.JwtTokenUtil;
import com.sy.spring.cloud.alibaba.module.web.ErrorEnum;
import com.sy.spring.cloud.alibaba.module.web.GrabException;
import com.sy.spring.cloud.alibaba.module.web.RespBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.sy.spring.cloud.alibaba.module.domain.auth.UserInfo;
import com.sy.spring.cloud.alibaba.auth.user.mapper.UserInfoMapper;
import com.sy.spring.cloud.alibaba.auth.user.service.UserInfoService;
@Service
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
            throw new GrabException(RespBean.CodeStatus.REQUEST,"请求输入帐号密码");
        }
        authLoginVo.setPassword(new BCryptPasswordEncoder().encode(authLoginVo.getPassword()));
        UserVo userVo = userInfoMapper.userLoginByEvidence(authLoginVo.getEvidence(), authLoginVo.getPassword());
        if (userVo!=null){
            UserLoginVo userLoginVo = new UserLoginVo();
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

}
