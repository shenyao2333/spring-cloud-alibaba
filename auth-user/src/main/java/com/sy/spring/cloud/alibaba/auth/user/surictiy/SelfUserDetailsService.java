
package com.sy.spring.cloud.alibaba.auth.user.surictiy;

import com.sy.spring.cloud.alibaba.module.web.ErrorEnum;
import com.sy.spring.cloud.alibaba.module.web.GrabException;
import com.sy.spring.cloud.alibaba.module.web.RespBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


/**
 * @Author: sy
 * @DateTime: 2020.3.15 16:18
 * @Description: 用户认证、角色分配
 */

@Component
@Slf4j
public class SelfUserDetailsService implements UserDetailsService {


   /* @Resource
    private SecurityUserService securityUserService;*/


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        /*SelfUserDetails user = securityUserService.selectByUserName(username);
        log.info("查询出来用户为---->"+user);
        if (user==null){
            throw  new GrabException(ErrorEnum.SYS);
        }*/
       throw new GrabException(-12,"23q4");

    }




}

