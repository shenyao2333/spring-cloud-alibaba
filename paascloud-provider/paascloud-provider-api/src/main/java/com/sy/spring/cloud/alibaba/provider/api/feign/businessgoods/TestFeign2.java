package com.sy.spring.cloud.alibaba.provider.api.feign.businessgoods;

import com.sy.spring.cloud.alibaba.provider.api.feign.businessgoods.fallback.EchoServiceFallbackFactory;
import com.sy.spring.cloud.alibaba.provider.basic.web.RespBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author sy
 * @date Created in 2020.7.12 21:26
 * @description
 */
@FeignClient(value ="business-goods" ,fallbackFactory = EchoServiceFallbackFactory.class)
public interface TestFeign2 {


    @GetMapping(path = "/api/testFeign")
    RespBean testFeign();

}
