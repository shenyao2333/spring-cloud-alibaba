package com.sy.spring.cloud.alibaba.auth.user.service.impl;

import com.sy.spring.cloud.alibaba.auth.user.domain.dto.AuthLoginVo;
import com.sy.spring.cloud.alibaba.auth.user.mapper.SelfUserDetailMapper;
import com.sy.spring.cloud.alibaba.auth.user.service.SelfUserDetailService;
import com.sy.spring.cloud.alibaba.auth.user.surictiy.SelfUserDetails;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author ：sy
 * @date ：Created in 2020.3.29 21:27
 * @description:
 */
@Service
public class SelfUserDetailServiceImpl implements SelfUserDetailService {

    @Resource
    private SelfUserDetailMapper selfUserDetailMapper;


    @Override
    public SelfUserDetails userLogin(AuthLoginVo authLoginVo) {
        SelfUserDetails user =  selfUserDetailMapper.userLogin(authLoginVo);
        return user;
    }
}
