package com.sy.spring.cloud.alibaba.business.user.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.sy.spring.cloud.alibaba.business.user.mapper.AuthRolePermissionMapper;
import com.sy.spring.cloud.alibaba.provider.basic.domain.auth.AuthRolePermission;
import com.sy.spring.cloud.alibaba.business.user.service.AuthRolePermissionService;
@Service
public class AuthRolePermissionServiceImpl implements AuthRolePermissionService{

    @Resource
    private AuthRolePermissionMapper authRolePermissionMapper;

    @Override
    public int insert(AuthRolePermission record) {
        return authRolePermissionMapper.insert(record);
    }

    @Override
    public int insertSelective(AuthRolePermission record) {
        return authRolePermissionMapper.insertSelective(record);
    }

    @Override
    public AuthRolePermission selectByPrimaryKey(Long id) {
        return authRolePermissionMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(AuthRolePermission record) {
        return authRolePermissionMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(AuthRolePermission record) {
        return authRolePermissionMapper.updateByPrimaryKey(record);
    }

}
