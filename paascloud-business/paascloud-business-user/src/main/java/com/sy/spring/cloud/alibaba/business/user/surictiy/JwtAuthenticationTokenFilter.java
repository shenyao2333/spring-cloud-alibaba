package com.sy.spring.cloud.alibaba.business.user.surictiy;

import com.alibaba.fastjson.JSON;
import com.sy.spring.cloud.alibaba.provider.basic.redis.RedisUtil;
import com.sy.spring.cloud.alibaba.provider.basic.utils.JwtTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * @Author: sy
 * @DateTime: 2020.3.15 20:58
 * @Description: 拦截器
 */
@Component
@Slf4j
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Resource
    private RedisUtil redisUtil;


    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        String token = JwtTokenUtil.resolveToken(httpServletRequest);
        if (token!=null){
            Map<Object, Object> hget = redisUtil.hget(token);
            if (hget!=null){
                String username = JwtTokenUtil.getUsername(token);
                SelfUserDetails userDetails = new SelfUserDetails();
                userDetails.setUserName(username);
                if (hget.get("roles")!=null){
                    List<GrantedAuthority> roles = JSON.parseArray(hget.get("roles").toString(), GrantedAuthority.class);
                    userDetails.setAuthorities(new HashSet<>(roles));
                }
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails,null, userDetails.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }
        //throw new GrabException(-1,"sdf");
        filterChain.doFilter(httpServletRequest, httpServletResponse);

    }
}

