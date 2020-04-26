package com.sy.spring.cloud.alibaba.module.utils;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;


import java.io.*;
import java.net.URL;
import java.util.Date;

/**
 * @author sy
 * @date Created in 2020.4.25 23:17
 * @description 上传图片
 */
public class UploadFileUtil {

    static String url = "C:\\Users\\my\\Pictures\\Camera Roll\\default.jpg";

    public static void main(String[] args) throws Exception {
        long l1 = System.currentTimeMillis();

        tset();
        long l2 = System.currentTimeMillis();
        System.out.println(l2-l1);

        long l3 = System.currentTimeMillis();
        tset2();
        long l4 = System.currentTimeMillis();
        System.out.println(l4-l3);



    }


    public static String  tset(){
        File file = new File(url);
        String endpoint = "oss-accelerate.aliyuncs.com";
        String accessKeyId = "LTAI4GL6UzaiiV7gsJcafTgK";
        String accessKeySecret = "PXWhibqBdS6yh9WYz4wmKnmtK8mnKj";
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        ossClient.putObject("social-image", "asdf.jpg", file);
        URL url = ossClient.generatePresignedUrl("social-image", "asdf.jpg", new Date(System.currentTimeMillis() + 360000L * 1000));
        // 上传字符串。
        // 关闭OSSClient。
        ossClient.shutdown();

        System.out.println(url.toString());

        return url.toString();
    }


    public static String  tset2() throws Exception{
        byte[] buffer = null;
        FileInputStream fis = new FileInputStream(url);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] b = new byte[5024];
        int n;
        while ((n = fis.read(b)) != -1)
        {
            bos.write(b, 0, n);
        }
        fis.close();
        bos.close();
        buffer = bos.toByteArray();


        String endpoint = "oss-accelerate.aliyuncs.com";
        String accessKeyId = "LTAI4GL6UzaiiV7gsJcafTgK";
        String accessKeySecret = "PXWhibqBdS6yh9WYz4wmKnmtK8mnKj";
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        ossClient.putObject("social-image", "asdf.jpg", new ByteArrayInputStream(buffer));
        URL url = ossClient.generatePresignedUrl("social-image", "asdf.jpg", new Date(System.currentTimeMillis() + 360000L * 1000));
        // 上传字符串。
        // 关闭OSSClient。
        ossClient.shutdown();
        System.out.println(url.toString());
        return url.toString();
    }

}
