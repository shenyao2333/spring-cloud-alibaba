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

    static String url = "C:\\Users\\my\\Pictures\\Camera Roll\\default.jpg";

    /**
     * OSS地址
     */
    static String ENDPOINT = "oss-accelerate.aliyuncs.com";

    static String accessKeyId = "LTAI4GL6UzaiiV7gsJcafTgK";
    static String accessKeySecret = "PXWhibqBdS6yh9WYz4wmKnmtK8mnKj";
    /**
     * buck名
     */
    static String BUCKETNAME="social-image";


    public static String  uploadOSS(File file){

        OSS ossClient = new OSSClientBuilder().build(ENDPOINT, accessKeyId, accessKeySecret);
        String name = file.getName();
        System.out.println(name);
        File parentFile = file.getParentFile();
        System.out.println(parentFile.getName());
        String fileName = getFileName();

        PutObjectRequest putObjectRequest =  new PutObjectRequest(BUCKETNAME,"3.jpg",file);


        URL url = ossClient.generatePresignedUrl(BUCKETNAME, "asdf.jpg", new Date(System.currentTimeMillis() + 360000L * 1000));


        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setHeader(OSSHeaders.OSS_STORAGE_CLASS, StorageClass.Standard.toString());
        metadata.setObjectAcl(CannedAccessControlList.Private);
        putObjectRequest.setMetadata(metadata);

        // 上传字符串。
        // 关闭OSSClient。
        ossClient.shutdown();

        System.out.println(url.toString());

        // 使用签名URL发送请求。
        Map<String, String> customHeaders = new HashMap<String, String>();
        // 添加GetObject请求头。
        customHeaders.put("Range", "bytes=100-1000");
        OSSObject object = ossClient.getObject(url,customHeaders);
        System.out.println(object.toString());

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


    private static String getFileName(){
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        return df.format(new Date())+ StringUtil.getRanString(15);
    }


    public static void main(String[] args) throws Exception {

        File file = new File(url);
        //  String s = uploadOSS(file);
        String s = uploadImg2Oss((MultipartFile) file);

    }

    public static String uploadImg2Oss(MultipartFile file) {
        if (file.getSize() > 5 * 1024 * 1024) {
            System.out.println("上传图片大小不能超过10M！");
            return null;
        }
        String originalFilename = file.getOriginalFilename();
        String substring = originalFilename.substring(originalFilename.lastIndexOf(".")).toLowerCase();
        Random random = new Random();
        String name = random.nextInt(10000) + System.currentTimeMillis() + substring;
        try {
            InputStream inputStream = file.getInputStream();
            uploadFile2OSS(inputStream, name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return name;
    }


    public static String uploadFile2OSS(InputStream instream, String fileName) {
        OSSClient ossClient = new OSSClient(ENDPOINT, accessKeyId, accessKeySecret);
        String ret = "";
        try {
            // 创建上传Object的Metadata
            ObjectMetadata objectMetadata = new ObjectMetadata();
            objectMetadata.setContentLength(instream.available());
            objectMetadata.setCacheControl("no-cache");
            objectMetadata.setHeader("Pragma", "no-cache");
            objectMetadata.setContentType(getcontentType(fileName.substring(fileName.lastIndexOf("."))));
            objectMetadata.setContentDisposition("inline;filename=" + fileName);
            // 上传文件
            PutObjectResult putResult = ossClient.putObject(BUCKETNAME,   fileName, instream, objectMetadata);
            ret = putResult.getETag();
        } catch (IOException e) {

        } finally {
            try {
                if (instream != null) {
                    instream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return ret;
    }


    /**
     * Description: 判断OSS服务文件上传时文件的contentType
     *
     * @param filenameExtension
     *            文件后缀
     * @return String
     */
    public static String getcontentType(String filenameExtension) {
        if (filenameExtension.equalsIgnoreCase("bmp")) {
            return "image/bmp";
        }
        if (filenameExtension.equalsIgnoreCase("gif")) {
            return "image/gif";
        }
        if (filenameExtension.equalsIgnoreCase("jpeg") || filenameExtension.equalsIgnoreCase("jpg")
                || filenameExtension.equalsIgnoreCase("png")) {
            return "image/jpeg";
        }
        if (filenameExtension.equalsIgnoreCase("html")) {
            return "text/html";
        }
        if (filenameExtension.equalsIgnoreCase("txt")) {
            return "text/plain";
        }
        if (filenameExtension.equalsIgnoreCase("vsd")) {
            return "application/vnd.visio";
        }
        if (filenameExtension.equalsIgnoreCase("pptx") || filenameExtension.equalsIgnoreCase("ppt")) {
            return "application/vnd.ms-powerpoint";
        }
        if (filenameExtension.equalsIgnoreCase("docx") || filenameExtension.equalsIgnoreCase("doc")) {
            return "application/msword";
        }
        if (filenameExtension.equalsIgnoreCase("xml")) {
            return "text/xml";
        }
        return "image/jpeg";
    }



}
