package com.sy.spring.cloud.alibaba.business.user.mapper;

import com.sy.spring.cloud.alibaba.provider.basic.domain.auth.AuthUserRole;

public interface AuthUserRoleMapper {
    int insert(AuthUserRole record);

    int insertSelective(AuthUserRole record);

    AuthUserRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AuthUserRole record);

    int updateByPrimaryKey(AuthUserRole record);
}
