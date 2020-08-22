package com.sy.spring.cloud.alibaba.business.user.mapper;

import com.sy.spring.cloud.alibaba.provider.basic.domain.auth.AuthRolePermission;

public interface AuthRolePermissionMapper {
    int insert(AuthRolePermission record);

    int insertSelective(AuthRolePermission record);

    AuthRolePermission selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AuthRolePermission record);

    int updateByPrimaryKey(AuthRolePermission record);
}
