package com.sy.spring.cloud.alibaba.business.goods.dubbo;

import com.sy.spring.cloud.alibaba.bus.api.dubbo.TestDobbo;
import org.apache.dubbo.config.annotation.Service;

/**
 * @author sy
 * @date Created in 2020.7.12 16:44
 * @description
 */
@Service(protocol = "dubbo")
public class TestDobboImpl implements TestDobbo {


    @Override
    public String echo(String param) {
        System.out.println("服务提供"+ param);
        return "服务提供 -- > "+param;
    }
}
