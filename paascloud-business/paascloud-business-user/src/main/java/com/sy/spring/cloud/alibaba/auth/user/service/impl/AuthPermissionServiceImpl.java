package com.sy.spring.cloud.alibaba.auth.user.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.sy.spring.cloud.alibaba.provider.basic.domain.auth.AuthPermission;
import com.sy.spring.cloud.alibaba.auth.user.mapper.AuthPermissionMapper;
import com.sy.spring.cloud.alibaba.auth.user.service.AuthPermissionService;
@Service
public class AuthPermissionServiceImpl implements AuthPermissionService{

    @Resource
    private AuthPermissionMapper authPermissionMapper;

    @Override
    public int insert(AuthPermission record) {
        return authPermissionMapper.insert(record);
    }

    @Override
    public int insertSelective(AuthPermission record) {
        return authPermissionMapper.insertSelective(record);
    }

    @Override
    public AuthPermission selectByPrimaryKey(Long id) {
        return authPermissionMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(AuthPermission record) {
        return authPermissionMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(AuthPermission record) {
        return authPermissionMapper.updateByPrimaryKey(record);
    }

}
