package com.sy.spring.cloud.alibaba.bus.rocketmq.rocketmq;

import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author sy
 * @date Created in 2020.6.2 21:35
 * @description
 */
@Service
public class ProviderService {

    @Resource
    private MessageChannel output;



    public void send(String message) {

        output.send(MessageBuilder.withPayload(message).build());
    }


}
