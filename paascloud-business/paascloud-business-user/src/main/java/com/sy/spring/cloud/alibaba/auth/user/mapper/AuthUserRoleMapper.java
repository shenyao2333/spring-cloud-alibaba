package com.sy.spring.cloud.alibaba.auth.user.mapper;

import com.sy.spring.cloud.alibaba.module.domain.auth.AuthUserRole;

public interface AuthUserRoleMapper {
    int insert(AuthUserRole record);

    int insertSelective(AuthUserRole record);

    AuthUserRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AuthUserRole record);

    int updateByPrimaryKey(AuthUserRole record);
}
