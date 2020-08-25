package com.sy.spring.cloud.alibaba.business.user.mapper;

import com.sy.spring.cloud.alibaba.provider.basic.domain.auth.AuthPermission;

public interface AuthPermissionMapper {

    int insert(AuthPermission record);


    int insertSelective(AuthPermission record);


    AuthPermission selectByPrimaryKey(Long id);


    int updateByPrimaryKeySelective(AuthPermission record);


    int updateByPrimaryKey(AuthPermission record);
}
