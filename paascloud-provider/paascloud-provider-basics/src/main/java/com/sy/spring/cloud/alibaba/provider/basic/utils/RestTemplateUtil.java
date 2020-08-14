package com.sy.spring.cloud.alibaba.provider.basic.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Iterator;
import java.util.Map;

/**
 * @author sy
 * @date Created in 2020.4.4 19:38
 * @description restTemplate封装根据类
 */
@Slf4j
public class RestTemplateUtil {


    /**
     * 封装的get请求，暂时只支持map传参，并且value只支持基本类型和String
     *
     * @param url
     * @param object
     * @return
     */
    public static JSONObject doGet(String url, Map object) {
        StringBuffer stringBuffer = new StringBuffer(url);
        if (object != null) {
            Iterator iterator =object.entrySet().iterator();
            if (iterator.hasNext()) {
                stringBuffer.append("?");
                Object element;
                while (iterator.hasNext()) {
                    element = iterator.next();
                    Map.Entry entry = (Map.Entry) element;
                    if (entry.getValue() != null) {
                        stringBuffer.append(element).append("&");
                    }
                    url = stringBuffer.substring(0, stringBuffer.length() - 1);
                }
            }
        }
        log.info("请求总路径为："+url);
        String body="";
        try {
            body = new RestTemplate().getForObject(url, String.class);
        }catch (HttpClientErrorException e){
            body =  e.getResponseBodyAsString();
        }
        JSONObject json = JSONObject.parseObject(body);
        return json;

    }


    /**
     * Post请求
     * @param url
     * @param handParams 路径传参
     * @param bodyParams 请求体参数
     * @return
     */
    public static JSONObject doPost(String url, Map handParams, LinkedMultiValueMap bodyParams){
        StringBuilder stringBuffer = new StringBuilder(url);
        if (handParams != null) {
            Iterator iterator = (handParams).entrySet().iterator();
            if (iterator.hasNext()) {
                stringBuffer.append("?");
                Object element;
                while (iterator.hasNext()) {
                    element = iterator.next();
                    Map.Entry entry = (Map.Entry) element;
                    if (entry.getValue() != null) {
                        stringBuffer.append(element).append("&");
                    }
                    url = stringBuffer.substring(0, stringBuffer.length() - 1);
                }
            }
        }
        log.info("请求路径为："+url);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity httpEntity = new HttpEntity(bodyParams, headers);
        String body="";
        try {
            body = new RestTemplate().postForEntity(url, httpEntity, String.class).getBody();
        }catch (HttpClientErrorException e){
            body =  e.getResponseBodyAsString();
        }
        JSONObject object = JSONObject.parseObject(body);
        return object;
    }


    /**
     * Post 只有请求体参数
     * @param url 请求路径
     * @param params  请求参数LinkedMultiValueMap 类型
     * @return
     */
    public static JSONObject doPost(String url ,LinkedMultiValueMap params){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity httpEntity = new HttpEntity(params, headers);
        String body="";
        try {
            body = new RestTemplate().postForEntity(url, httpEntity, String.class).getBody();
        }catch (HttpClientErrorException e){
            body =  e.getResponseBodyAsString();
        }
        JSONObject object = JSONObject.parseObject(body);
        return object;
    }


    /**
     * Post 请求，参数传JSON格式
     * @param url
     * @param param 请求参数JSON对象
     * @return
     */
    public static  JSONObject doPost(String url,JSONObject param){
        String data = JSON.toJSONString(param);
        long l = System.currentTimeMillis();
        log.info("请求路径-->"+url);
        log.info("发送内容-->"+data);
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
        HttpEntity<String> formEntity = new HttpEntity<String>(data, headers);
        String body="";
        try {
            body = new RestTemplate().postForEntity(url, formEntity, String.class).getBody();
        }catch (HttpClientErrorException e){
            body =  e.getResponseBodyAsString();
        }
        long l2 = System.currentTimeMillis();
        long time = l2-l;
        log.info("请求花费时间："+time);
        JSONObject object = JSONObject.parseObject(body);
        log.info("返回数据："+object);
        return object;
    }


    /**
     *  POST 请求，JSON格式请求体，并且带有请求头
     * @param url 请求路径
     * @param param 请求体参数
     * @param header 请求报文头
     * @return
     */
    public static  JSONObject doPost(String url,JSONObject param,Map header){
        String data = JSON.toJSONString(param);
        long l = System.currentTimeMillis();
        log.info("请求路径-->"+url);
        log.info("发送内容-->"+data);
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
        for (Object o : header.keySet()){
            headers.add(o.toString(),header.get(o).toString());
        }
        HttpEntity<String> formEntity = new HttpEntity<String>(data, headers);
        String body="";
        try {
            body = new RestTemplate().postForEntity(url, formEntity, String.class).getBody();
        }catch (HttpClientErrorException e){
            body =  e.getResponseBodyAsString();
        }
        long l2 = System.currentTimeMillis();
        long time = l2-l;
        log.info("请求花费时间："+time);
        JSONObject object = JSONObject.parseObject(body);
        return object;
    }


}
