package com.sy.spring.cloud.alibaba.business.user.service;
import com.sy.spring.cloud.alibaba.provider.basic.domain.auth.AuthPermission;
public interface AuthPermissionService{


    int insert(AuthPermission record);

    int insertSelective(AuthPermission record);

    AuthPermission selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AuthPermission record);

    int updateByPrimaryKey(AuthPermission record);

}
