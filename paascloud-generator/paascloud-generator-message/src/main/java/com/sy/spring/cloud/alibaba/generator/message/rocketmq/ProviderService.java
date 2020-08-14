package com.sy.spring.cloud.alibaba.generator.message.rocketmq;

import org.apache.rocketmq.spring.support.RocketMQHeaders;
import org.springframework.messaging.Message;
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
       // output.
        output.send(MessageBuilder.withPayload(message).build());
    }

    public String testCustomInterfaceSendMsg(String tage) {
        Message<String> message = MessageBuilder.withPayload("send message")
                .setHeader(RocketMQHeaders.TAGS, "tag2")
                .setHeader("mytag", "my-tag")
                .build();
       // output
        return "success";
    }


}
