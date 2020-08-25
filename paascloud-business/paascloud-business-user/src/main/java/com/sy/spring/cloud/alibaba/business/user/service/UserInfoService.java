package com.sy.spring.cloud.alibaba.business.user.service;

import com.sy.spring.cloud.alibaba.business.user.domain.dto.AuthLoginDto;
import com.sy.spring.cloud.alibaba.business.user.domain.dto.UpdPasswordDto;
import com.sy.spring.cloud.alibaba.business.user.domain.dto.UpdUserInfoDto;
import com.sy.spring.cloud.alibaba.business.user.domain.vo.UserLoginVo;
import com.sy.spring.cloud.alibaba.business.user.domain.vo.UserVo;
import com.sy.spring.cloud.alibaba.provider.basic.domain.auth.UserInfo;
/**
 * @author sy
 *
 */
public interface UserInfoService{


    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);

    /**
     * 用户登陆
     * @param authLoginVo
     */
    UserLoginVo userLoginByEvidence(AuthLoginDto authLoginVo);

    /**
     * 使用手机号查找用户
     * @param mobile
     * @return
     */
    UserVo selectByMobile(String mobile);

    /**
     * 使用邮箱查找用户
     * @param email
     * @return
     */
    UserVo selectByEmail(String email);

    /**
     * 校验帐号信息
     * @param mobile 手机号
     * @param email 邮箱
     * @param qq QQ号
     * @return
     */
    String checkAcc(String mobile, String email, String qq);


    /**
     * 修改用户信息
     * @param userInfoDto
     * @return
     */
    int updUserByDto(UpdUserInfoDto userInfoDto);

    /**
     * 修改密码
     * @param passwordDto
     * @return
     */
    int updPasswordByDto(UpdPasswordDto passwordDto);
}
