package com.sy.spring.cloud.alibaba.auth.user.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.sy.spring.cloud.alibaba.module.domain.auth.AuthRole;
import com.sy.spring.cloud.alibaba.auth.user.mapper.AuthRoleMapper;
import com.sy.spring.cloud.alibaba.auth.user.service.AuthRoleService;
@Service
public class AuthRoleServiceImpl implements AuthRoleService{

    @Resource
    private AuthRoleMapper authRoleMapper;

    @Override
    public int insert(AuthRole record) {
        return authRoleMapper.insert(record);
    }

    @Override
    public int insertSelective(AuthRole record) {
        return authRoleMapper.insertSelective(record);
    }

    @Override
    public AuthRole selectByPrimaryKey(Long id) {
        return authRoleMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(AuthRole record) {
        return authRoleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(AuthRole record) {
        return authRoleMapper.updateByPrimaryKey(record);
    }

}
