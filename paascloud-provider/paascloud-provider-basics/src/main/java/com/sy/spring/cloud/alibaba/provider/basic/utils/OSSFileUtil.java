package com.sy.spring.cloud.alibaba.provider.basic.utils;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.*;
import com.sy.spring.cloud.alibaba.provider.basic.web.GrabException;
import org.springframework.web.multipart.MultipartFile;


import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author sy
 * @date Created in 2020.4.25 23:17
 * @description oss上传图片
 */
public class OSSFileUtil {




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




    public static String getFileName(){
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        return df.format(new Date())+ StringUtil.getRanString(15);
    }

    public static String getFileNameBySuffix(String suffix){
        suffix=suffix.replace("\\.","");
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        return df.format(new Date())+ StringUtil.getRanString(15)+"."+suffix;
    }


    /**
     *
     * @param file 文件
     * @param directory 目录
     * @return
     */
    public static String  upload(MultipartFile file,String directory){
        directory= directory!=null&&directory.trim().length()>0?directory+"/":"";
        OSS ossClient = new OSSClientBuilder().build(ENDPOINT, accessKeyId, accessKeySecret);

        // 创建PutObjectRequest对象。
        PutObjectRequest putObjectRequest =null;
        String name = "";
        try {
            String originalFilename = file.getOriginalFilename();
            name = originalFilename.substring(originalFilename.lastIndexOf("."));
            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentType(getcontentType(name));
            metadata.setObjectAcl(CannedAccessControlList.PublicRead);
            name = getFileName()+name;

            putObjectRequest = new PutObjectRequest(BUCKETNAME,directory+ name,file.getInputStream());
            putObjectRequest.setMetadata(metadata);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ossClient.putObject(putObjectRequest);
        ossClient.shutdown();

        return "http://" + BUCKETNAME + "." + ENDPOINT + "/" + directory+name;
    }


    /**
     *
     * @param inputStream 输入流
     * @param directory 文件目录
     * @param name 文件名
     * @return
     */
    public static String  uploadByStream(InputStream inputStream,String directory,String name){
        if (name==null||name.trim().length()<1){
            throw  new GrabException(5002,"文件名不能为空");
        }
        directory= directory!=null&&directory.trim().length()>0?directory+"/":"";
        OSS ossClient = new OSSClientBuilder().build(ENDPOINT, accessKeyId, accessKeySecret);
        // 创建PutObjectRequest对象。
        PutObjectRequest putObjectRequest =null;

        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentType(getcontentType(name.substring(name.lastIndexOf("."))));
        metadata.setObjectAcl(CannedAccessControlList.PublicRead);
        putObjectRequest = new PutObjectRequest(BUCKETNAME,directory+ name,inputStream);
        putObjectRequest.setMetadata(metadata);
        ossClient.putObject(putObjectRequest);
        ossClient.shutdown();
        return "http://" + BUCKETNAME + "." + ENDPOINT + "/" + directory+name;
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
        if (".pdf".equalsIgnoreCase(filenameExtension)){
            return "application/pdf";
        }
        return "image/jpg";
    }


}
