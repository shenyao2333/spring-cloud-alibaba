package com.sy.spring.cloud.alibaba.business.user.service;

import com.sy.spring.cloud.alibaba.business.user.domain.dto.AuthLoginDto;
import com.sy.spring.cloud.alibaba.business.user.domain.dto.RegisterUserDto;
import com.sy.spring.cloud.alibaba.business.user.domain.vo.UserLoginVo;
import com.sy.spring.cloud.alibaba.business.user.surictiy.SelfUserDetails;

/**
 * <p>
 * </p>
 *
 * @author ：sy
 * @date ：Created in 2020.3.29 21:24
 * @version:
 */
public interface SelfUserDetailService {

    /**
     * 用户登录
     * @param authLoginVo
     * @return
     */
    SelfUserDetails userLogin(AuthLoginDto authLoginVo);

    SelfUserDetails selectByUserName(String username);

    /**
     * 通过手机验证码登陆
     * @param mobile
     * @param code
     * @return
     */
    UserLoginVo userLoginByCode(String mobile, String code);

    /**
     * 获取手机验证码
     * @param mobile
     * @return
     */
    void getMobileCode(String mobile);


    /**
     * 用户注册
     * @param registerUserDto
     */
    UserLoginVo register(RegisterUserDto registerUserDto);

    /**
     * 获取邮箱验证码
     * @param email
     */
    void getEmailCode(String email);
}
