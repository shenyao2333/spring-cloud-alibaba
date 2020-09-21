package com.sy.spring.cloud.alibaba.business.social.controller;

import com.sy.spring.cloud.alibaba.business.social.websocket.WebSocketServer;
import com.sy.spring.cloud.alibaba.provider.basic.web.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @author sy
 * @date Created in 2020.9.21 21:33
 * @description
 */
@RestController
@RequestMapping("/testWebSocket")
@Api(tags = "简单socket连接")
public class WebSocketController  {

    @Resource
    private WebSocketServer webSocketServer;


    @GetMapping("/sendToUser")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "用户id",name = "userId"),
            @ApiImplicitParam(value = "发送消息",name = "msg")
    })
    @ApiOperation(value = "给指定的人发送消息")
    public R send(@RequestParam Integer userId, @RequestParam String msg){
        try {
            webSocketServer.sendToUser(msg,userId);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return R.ok("发送成功");
    }


    @GetMapping("/sendAllUser")
    @ApiImplicitParam(value = "消息内容",name = "msg")
    @ApiOperation(value = "给所有人发送消息")
    public R sendAllUser( @RequestParam String msg){
        try {
            webSocketServer.sendtoAll(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return R.ok("发送成功");
    }



    @GetMapping("/getUserList")
    @ApiOperation(value = "获取全部在线用户")
    public R<Enumeration<Integer> > getUserList(){
        Enumeration<Integer> userList = WebSocketServer.getUserList();
        return R.ok(userList);
    }




}
