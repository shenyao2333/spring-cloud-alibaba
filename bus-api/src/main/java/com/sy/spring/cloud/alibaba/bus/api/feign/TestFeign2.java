package com.sy.spring.cloud.alibaba.bus.api.feign;

import com.sy.spring.cloud.alibaba.module.web.RespBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author sy
 * @date Created in 2020.7.12 21:26
 * @description
 */
@FeignClient(value ="business-goods")
public interface TestFeign2 {

    @PostMapping("/api/testFeign")
    RespBean testFeign();

}
