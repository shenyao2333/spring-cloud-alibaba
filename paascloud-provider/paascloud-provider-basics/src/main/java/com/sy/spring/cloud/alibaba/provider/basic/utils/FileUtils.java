package com.sy.spring.cloud.alibaba.provider.basic.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * @author sy
 * @date: 2020/7/10 10:21
 * @description 文件的工具类
 */
public class FileUtils {
    /**
     * 得到图片字节流 数组大小
     */
    public static byte[] readStream(InputStream inStream) throws Exception {
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = -1;
        while ((len = inStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, len);
        }
        outStream.close();
        inStream.close();
        return outStream.toByteArray();
    }

    /**
     * 将文件转换成Byte数组
     *
     * @param file
     * @return
     */
    public static byte[] getBytesByFile(File file) {
        try {
            FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream bos = new ByteArrayOutputStream(1000);
            byte[] b = new byte[1000];
            int n;
            while ((n = fis.read(b)) != -1) {
                bos.write(b, 0, n);
            }
            fis.close();
            byte[] data = bos.toByteArray();
            bos.close();
            return data;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * MultipartFile转File
     *
     * @param param
     * @return
     */
    public static File transfer(MultipartFile param) {
        if (!param.isEmpty()) {
            File file = null;
            try {
                InputStream in = param.getInputStream();
                file = new File(param.getOriginalFilename());
                OutputStream out = new FileOutputStream(file);
                int bytesRead = 0;
                byte[] buffer = new byte[8192];
                while ((bytesRead = in.read(buffer, 0, 8192)) != -1) {
                    out.write(buffer, 0, bytesRead);
                }
                in.close();
                out.close();
                return file;
            } catch (Exception e) {
                e.printStackTrace();
                return file;
            }
        }
        return null;
    }

    /**
     * 获取指定文件的输入流
     *
     * @param logoPath 文件的路径
     * @return
     */
    public static InputStream getResourceAsStream(String logoPath) {
        return FileUtils.class.getResourceAsStream(logoPath);
    }

    /**
     * 将InputStream写入到File中
     *
     * @param ins
     * @param file
     * @throws IOException
     */
    public void inputstreamtofile(InputStream ins, File file) throws IOException {
        OutputStream os = new FileOutputStream(file);
        int bytesRead = 0;
        byte[] buffer = new byte[8192];
        while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
            os.write(buffer, 0, bytesRead);
        }
        os.close();
        ins.close();
    }
}
