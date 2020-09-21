package com.sy.spring.cloud.alibaba.business.social.websocket;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author sy
 * @date Created in 2020.9.21 21:24
 * @description
 */
@Component
@ServerEndpoint(value = "/testSocket/{userId}")
@Slf4j
public class WebSocketServer {

    /**
     *  在线人数
     */
    private static int onlineCount = 0;
    /**
     *  在线人员注册 一个用户可以多浏览器登录
     */
    private static ConcurrentHashMap<Integer, WebSocketServer> webSocketSet = new ConcurrentHashMap<Integer, WebSocketServer>();
    /**
     * 与某个客户端的连接会话，需要通过它来给客户端发送数据
     */
    private Session session;
    /**
     * 用户ID
     */
    private Integer userId ;

    /**
     * 打开连接回调方法
     * @param userId 用户ID
     * @param session 客户端session
     */
    @OnOpen
    public void onOpen(@PathParam(value = "userId") Integer userId, Session session) {
        WebSocketServer webSocketServer = new WebSocketServer();
        webSocketServer.userId = userId;
        webSocketServer.session =session;
        webSocketSet.put(userId,this);
        //在线数加1
        addOnlineCount();
        log.info("有一连接！当前在线人数为" + getOnlineCount());
    }

    /**
     * 关闭连接回调方法
     * @param userId 用户ID
     */
    @OnClose
    public void onClose(@PathParam(value = "userId") Integer userId) {
        webSocketSet.remove(userId);
        subOnlineCount();           //在线数减1
        log.info("有一连接关闭！当前在线人数为" + getOnlineCount());
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息*/
    @OnMessage
    public void onMessage(String message, Session session) {
        log.info("来自客户端的消息:" + message);
        //可以自己约定字符串内容，比如 内容|0 表示信息群发，内容|X 表示信息发给id为X的用户

    }

    /**
     * 发生错误回调方法
     * @param session 连接会话
     * @param error 错误
     */
    @OnError
    public void onError(Session session, Throwable error) {
        log.error("发生错误");
        error.printStackTrace();
    }

    public static  Enumeration<Integer> getUserList(){
        Enumeration<Integer> keys = webSocketSet.keys();
        return keys;
    }



    /**
     * 发送信息
     * @param message 消息
     * @throws IOException 异常
     */
    public void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
    }

    /**
     * 发送信息给指定ID用户，如果用户不在线则返回不在线信息给自己
     * @param message 消息
     * @param sendUserId 用户ID
     * @throws IOException 异常
     */
    public void sendToUser(String message,Integer sendUserId) throws IOException {
        System.out.println(webSocketSet.toString());
        WebSocketServer webSocketServer = webSocketSet.get(sendUserId);
        if (webSocketServer!=null){
            webSocketServer.sendMessage(message);
        }
    }

    /**
     * 发送信息给所有人
     * @param message 消息
     * @throws IOException 异常
     */
    public void sendtoAll(String message) throws IOException {
        for (WebSocketServer value : webSocketSet.values()) {
            value.sendMessage(message);
        }
    }


    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        WebSocketServer.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        WebSocketServer.onlineCount--;
    }






}
