package com.sy.spring.cloud.alibaba.module.service;

import com.alibaba.fastjson.JSONObject;
import com.sy.spring.cloud.alibaba.module.utils.RestTemplateUtil;
import org.springframework.stereotype.Service;

/**
 * @author sy
 * @date Created in 2020.4.4 19:32
 * @description 手机验证码
 */
@Service
public class YunSendPhoneMsg {

    /**
     * 用户账号标识
     */
    private static String SID="7c65102b5243a08e15dbb460dc99570b";

    /**
     * 验证token
     */
    private static String TOKEN="84eabacb2f480aacd8baf0da7fb97835";

    /**
     * 创建应用时系统分配的唯一标示
     */
    private static String APPID="705dd79346fb4469afa34f8f645422b2";

    /**
     * 请求URL
     */
    private static String SEND_URL="https://open.ucpaas.com/ol/sms/sendsms";


    /**
     * 发送验证码
     * @param templateid
     * @param mobile
     * @param code
     * @return
     */
    public static boolean getCode(String templateid,String mobile,String code){
        JSONObject rest = new JSONObject();
        rest.put("sid",SID);
        rest.put("token",TOKEN);
        rest.put("appid",APPID);
        rest.put("templateid",templateid);
        rest.put("mobile",mobile);
        rest.put("param",code);
        JSONObject jsonObject = RestTemplateUtil.doPost(SEND_URL, rest);
        return "0".equals(jsonObject.get("code").toString());
    }









}
