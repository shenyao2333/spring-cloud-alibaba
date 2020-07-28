package com.sy.spring.cloud.alibaba.bus.api.feign;

import com.sy.spring.cloud.alibaba.module.web.RespBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author sy
 * @date Created in 2020.7.12 21:26
 * @description
 */
@FeignClient(value ="business-social")
//@FeignClient(value ="business-social",fallbackFactory = TestFeignFallbackFactory.class)
public interface TestFeign {

    @GetMapping(value="/api/testFeign")
    RespBean testFeign(@RequestParam(value = "name", required = false) String name);

}
