package com.sy.spring.cloud.alibaba.bus.api.feign;

import com.sy.spring.cloud.alibaba.module.web.RespBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author sy
 * @date Created in 2020.7.12 21:26
 * @description
 */
@FeignClient(value ="business-social")
//@FeignClient(value ="business-social",fallbackFactory = TestFeignFallbackFactory.class)
public interface TestFeign {

    @GetMapping("/api/testFeign")
    RespBean testFeign(@RequestParam(value = "name") String name);

}
