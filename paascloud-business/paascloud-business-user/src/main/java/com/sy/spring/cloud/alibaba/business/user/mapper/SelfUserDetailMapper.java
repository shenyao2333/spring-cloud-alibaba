package com.sy.spring.cloud.alibaba.business.user.mapper;

import com.sy.spring.cloud.alibaba.business.user.domain.dto.AuthLoginDto;
import com.sy.spring.cloud.alibaba.business.user.surictiy.SelfUserDetails;

/**
 * @author ：sy
 * @date ：Created in 2020.3.29 21:27
 * @description: Security处理类
 */
public interface SelfUserDetailMapper {


    SelfUserDetails userLogin(AuthLoginDto authLoginVo);
}
