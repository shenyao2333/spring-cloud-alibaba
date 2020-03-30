package com.sy.spring.cloud.alibaba.auth.user.mapper;

import com.sy.spring.cloud.alibaba.auth.user.domain.dto.AuthLoginVo;
import com.sy.spring.cloud.alibaba.auth.user.surictiy.SelfUserDetails;

/**
 * @author ：sy
 * @date ：Created in 2020.3.29 21:27
 * @description: Security处理类
 */
public interface SelfUserDetailMapper {


    SelfUserDetails userLogin(AuthLoginVo authLoginVo);
}
