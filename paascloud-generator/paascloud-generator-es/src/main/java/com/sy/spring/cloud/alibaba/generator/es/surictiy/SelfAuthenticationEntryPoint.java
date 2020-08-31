package com.sy.spring.cloud.alibaba.generator.es.surictiy;

import com.alibaba.fastjson.JSONObject;
import com.sy.spring.cloud.alibaba.provider.basic.redis.RedisUtil;
import com.sy.spring.cloud.alibaba.provider.basic.web.R;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: sy
 * @DateTime: 2020.3.15 17:14
 * @Description: 登录异常处理
 */

@Component
public class SelfAuthenticationEntryPoint  implements AuthenticationEntryPoint{

    /**
     * 未登录
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @param e
     * @throws IOException
     * @throws ServletException
     */



    @Resource
    private RedisUtil redisUtil;



    /**
     * 未登录
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @param e
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        httpServletResponse.setContentType("application/json;charset=UTF-8");
        httpServletResponse.setContentType("text/javascript;charset=utf-8");
        httpServletResponse.getWriter().print(JSONObject.toJSONString(R.fail(40001, "请先登录")));
    }






}
