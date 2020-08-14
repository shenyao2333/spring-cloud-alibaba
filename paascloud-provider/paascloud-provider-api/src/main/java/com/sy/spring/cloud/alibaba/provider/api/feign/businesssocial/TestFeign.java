package com.sy.spring.cloud.alibaba.provider.api.feign.businesssocial;

import com.sy.spring.cloud.alibaba.provider.basic.web.RespBean;
import org.springframework.cloud.openfeign.FeignClient;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author sy
 * @date Created in 2020.7.12 21:26
 * @description
 */
@FeignClient(value ="business-social")
public interface TestFeign {

    @PostMapping("/api/testFeign2")
    RespBean testFeign(@RequestParam(value = "name") String name);

}
