package com.sy.spring.cloud.alibaba.auth.user.service;

import com.sy.spring.cloud.alibaba.module.domain.auth.AuthRolePermission;
public interface AuthRolePermissionService{


    int insert(AuthRolePermission record);

    int insertSelective(AuthRolePermission record);

    AuthRolePermission selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AuthRolePermission record);

    int updateByPrimaryKey(AuthRolePermission record);

}
