package com.sy.spring.cloud.alibaba.module.utils;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.internal.OSSHeaders;
import com.aliyun.oss.model.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.*;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author sy
 * @date Created in 2020.4.25 23:17
 * @description 上传图片
 */
public class UploadFileUtil {


    /**
     * OSS地址
     */
    static String ENDPOINT = "oss-accelerate.aliyuncs.com";

    static String accessKeyId = "XXXXX";
    static String accessKeySecret = "XXXXXX";
    /**
     * buck名
     */
    static String BUCKETNAME="social-XXXX";





    private static String getFileName(){
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        return df.format(new Date())+ StringUtil.getRanString(15);
    }






    public static String  upload(MultipartFile file){
        OSS ossClient = new OSSClientBuilder().build(ENDPOINT, accessKeyId, accessKeySecret);

        // 创建PutObjectRequest对象。
        PutObjectRequest putObjectRequest =null;
        String name = "";
        try {
            //如果需要上传时设置存储类型与访问权限，请参考以下示例代码。
            String originalFilename = file.getOriginalFilename();
            name = originalFilename.substring(originalFilename.lastIndexOf("."));

            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentType(getcontentType(name));
            metadata.setObjectAcl(CannedAccessControlList.PublicRead);
            name = getFileName()+name;

            putObjectRequest = new PutObjectRequest(BUCKETNAME, name,file.getInputStream());
            putObjectRequest.setMetadata(metadata);

          //  String canonicalPath = putObjectRequest.getFile().getCanonicalPath();
            //String canonicalPath = putObjectRequest.getFile().getCanonicalPath();
           // System.out.println(canonicalPath);

        } catch (IOException e) {
            e.printStackTrace();
        }

        // 上传文件。
        ossClient.putObject(putObjectRequest);
        // 关闭OSSClient。
        ossClient.shutdown();

        return "http://" + BUCKETNAME + "." + ENDPOINT + "/" + name;
    }


    /**
     * Description: 判断OSS服务文件上传时文件的contentType
     *
     * @param filenameExtension
     *            文件后缀
     * @return String
     */
    public static String getcontentType(String filenameExtension) {
        if (".bmp".equalsIgnoreCase(filenameExtension)) {
            return "image/bmp";
        }
        if (".gif".equalsIgnoreCase(filenameExtension)) {
            return "image/gif";
        }
        if (".jpeg".equalsIgnoreCase(filenameExtension) || ".jpg".equalsIgnoreCase(filenameExtension)
                || ".png".equalsIgnoreCase(filenameExtension)) {
            return "image/jpg";
        }
        if (".html".equalsIgnoreCase(filenameExtension)) {
            return "text/html";
        }
        if (".txt".equalsIgnoreCase(filenameExtension)) {
            return "text/plain";
        }
        if (".vsd".equalsIgnoreCase(filenameExtension)) {
            return "application/vnd.visio";
        }
        if (".pptx".equalsIgnoreCase(filenameExtension) || ".ppt".equalsIgnoreCase(filenameExtension)) {
            return "application/vnd.ms-powerpoint";
        }
        if (".docx".equalsIgnoreCase(filenameExtension) || ".doc".equalsIgnoreCase(filenameExtension)) {
            return "application/msword";
        }
        if (".xml".equalsIgnoreCase(filenameExtension)) {
            return "text/xml";
        }
        return "image/jpg";
    }


}
