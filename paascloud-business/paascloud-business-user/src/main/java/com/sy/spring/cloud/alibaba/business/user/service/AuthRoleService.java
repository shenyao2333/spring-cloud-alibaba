package com.sy.spring.cloud.alibaba.business.user.service;

import com.sy.spring.cloud.alibaba.provider.basic.domain.auth.AuthRole;
public interface AuthRoleService{


    int insert(AuthRole record);

    int insertSelective(AuthRole record);

    AuthRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AuthRole record);

    int updateByPrimaryKey(AuthRole record);

}
