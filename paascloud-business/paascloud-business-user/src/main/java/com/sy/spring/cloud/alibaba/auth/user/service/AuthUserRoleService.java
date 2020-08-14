package com.sy.spring.cloud.alibaba.auth.user.service;

import com.sy.spring.cloud.alibaba.provider.basic.domain.auth.AuthUserRole;
public interface AuthUserRoleService{


    int insert(AuthUserRole record);

    int insertSelective(AuthUserRole record);

    AuthUserRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AuthUserRole record);

    int updateByPrimaryKey(AuthUserRole record);

}
