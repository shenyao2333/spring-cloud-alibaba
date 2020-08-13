package com.sy.spring.cloud.alibaba.auth.user.mapper;

import com.sy.spring.cloud.alibaba.auth.user.domain.vo.UserVo;
import com.sy.spring.cloud.alibaba.module.domain.auth.UserInfo;
import org.apache.ibatis.annotations.Param;

public interface UserInfoMapper {
    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);

    /**
     * 用户根据帐号密码登陆
     *
     * @param evidence
     * @return
     */
    UserInfo userLoginByEvidence(@Param("evidence") String evidence);

    /**
     * 使用邮箱查找用户
     *
     * @param email
     * @return
     */
    UserVo selectByEmail(String email);

    /**
     * 使用手机号查找用户
     *
     * @param mobile
     * @return
     */
    UserVo selectByMobile(String mobile);

    /**
     * 校验帐号信息是否被注册过
     *
     * @param mobile
     * @param email
     * @param qq
     * @return
     */
    String checkAcc(@Param("mobile") String mobile, @Param("email") String email, @Param("qq") String qq);
}
