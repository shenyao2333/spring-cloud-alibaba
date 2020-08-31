package com.sy.spring.cloud.alibaba.business.user.config;

import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.util.AntPathMatcher;

/**
 * @author sy
 * @date Created in 2020.8.26 22:00
 * @description
 */
public class TestConfig {


    public static void main(String[] args) {

        AntPathMatcher pathMatcher = new AntPathMatcher();
        System.out.println(pathMatcher.match("/test/**", "/test/sdf"));


    }
}
