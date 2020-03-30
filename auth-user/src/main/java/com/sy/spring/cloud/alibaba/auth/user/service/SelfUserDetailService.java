package com.sy.spring.cloud.alibaba.auth.user.service;

import com.sy.spring.cloud.alibaba.auth.user.domain.dto.AuthLoginVo;
import com.sy.spring.cloud.alibaba.auth.user.surictiy.SelfUserDetails;

/**
 * <p>
 * </p>
 *
 * @author ：sy
 * @date ：Created in 2020.3.29 21:24
 * @version:
 */
public interface SelfUserDetailService {

    /**
     * 用户登录
     * @param authLoginVo
     * @return
     */
    SelfUserDetails userLogin(AuthLoginVo authLoginVo);

}
