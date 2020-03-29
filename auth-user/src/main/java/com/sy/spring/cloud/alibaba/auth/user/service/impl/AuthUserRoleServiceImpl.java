package com.sy.spring.cloud.alibaba.auth.user.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.sy.spring.cloud.alibaba.module.domain.auth.AuthUserRole;
import com.sy.spring.cloud.alibaba.auth.user.mapper.AuthUserRoleMapper;
import com.sy.spring.cloud.alibaba.auth.user.service.AuthUserRoleService;
@Service
public class AuthUserRoleServiceImpl implements AuthUserRoleService{

    @Resource
    private AuthUserRoleMapper authUserRoleMapper;

    @Override
    public int insert(AuthUserRole record) {
        return authUserRoleMapper.insert(record);
    }

    @Override
    public int insertSelective(AuthUserRole record) {
        return authUserRoleMapper.insertSelective(record);
    }

    @Override
    public AuthUserRole selectByPrimaryKey(Long id) {
        return authUserRoleMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(AuthUserRole record) {
        return authUserRoleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(AuthUserRole record) {
        return authUserRoleMapper.updateByPrimaryKey(record);
    }

}
