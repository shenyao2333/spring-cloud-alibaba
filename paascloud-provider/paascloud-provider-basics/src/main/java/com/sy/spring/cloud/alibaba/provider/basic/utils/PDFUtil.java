package com.sy.spring.cloud.alibaba.provider.basic.utils;

import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.util.List;
import java.util.*;

/**
 * @author sy
 * @date: 2020/7/13 18:24
 * @description PDF填充工具类
 */
@Slf4j
public class PDFUtil {


    /**
     * pdf填充，返回一个输入流
     * @param map
     * @param inUrl
     * @return
     */
    public static InputStream convertTransData(Map map ,String inUrl){
        if (map == null || map.isEmpty()){
            return null;
        }
        InputStream inputStream = null;
        try {
            inputStream = new URL(inUrl).openStream();
        } catch (IOException e) {
            log.error("获取下载资源失败");
            e.printStackTrace();
        }
        ByteArrayOutputStream out = null;
        try {
            out = (ByteArrayOutputStream)generate(
                    new PdfReader(inputStream),
                    map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ByteArrayInputStream ret = new ByteArrayInputStream(out.toByteArray());
        return ret;

    }





    public static InputStream convertTransData(Map map,String inUrl,String toUrl) {
        if (map == null || map.isEmpty()){
            return null;
        }
        try {;
            InputStream in =new URL(inUrl).openStream();
            ByteArrayOutputStream out = (ByteArrayOutputStream)generate(
                            new PdfReader(in),
                            map);
            ByteArrayInputStream ret = new ByteArrayInputStream(out.toByteArray());
            //将pdf字节流输出到文件流
            OutputStream fos = new FileOutputStream(toUrl);
            fos.write(out.toByteArray());
            fos.close();
            out.close();
            return ret;
        } catch (Exception e) {
           log.error("生成pdf错误"+ e.getMessage());
        }
        return null;
    }

    /**
     *  将数据，填入pdf表单域
     *
     * */
    public static OutputStream generate(PdfReader template, Map data) throws Exception {
        BaseFont bfChinese = BaseFont.createFont("STSong-Light",
                "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();

            PdfStamper stamp = new PdfStamper(template, out);
            AcroFields form = stamp.getAcroFields();

            // set the field values in the pdf form
            for (Iterator it = data.keySet().iterator(); it.hasNext();) {
                String key = (String) it.next();
                String value =  data.get(key).toString();
                form.setFieldProperty(key, "textfont", bfChinese, null);
                form.setField(key, value);
            }
            stamp.setFormFlattening(true);
            stamp.close();
            template.close();
            return out;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }


    /**
     * pdf 转图片
     * @param file
     * @param imageFilePath 图片路径
     * @return
     */
    public static boolean pdf2Img(File file,String imageFilePath) {
        try {
            //生成图片保存
            byte[] data = pdfToPic(PDDocument.load(file),200);
            File imageFile = new File(imageFilePath);
            //按比例压缩图片
            ImageThumbUtil.thumbImage(data, 1, imageFilePath);
            return true;
        } catch (Exception e) {
            log.error("pdf转图片异常");
            e.printStackTrace();
        }

        return false;
    }


    public static InputStream pdfToImg(InputStream inputStream,int dpi){
        try {
            byte[] data = pdfToPic(PDDocument.load(inputStream),dpi);
            return new ByteArrayInputStream(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
       return null;
    }



    /**
     * pdf转图片
     */
    private static byte[] pdfToPic(PDDocument pdDocument,int dpi) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        List<BufferedImage> piclist = new ArrayList<BufferedImage>();
        try {
            PDFRenderer renderer = new PDFRenderer(pdDocument);
            for (int i = 0; i < pdDocument.getNumberOfPages(); i++) {
                // 0 表示第一页，300 表示转换 dpi，越大转换后越清晰，相对转换速度越慢
                BufferedImage image = renderer.renderImageWithDPI(i, dpi);
                piclist.add(image);
            }
            // 总高度 总宽度 临时的高度 , 或保存偏移高度 临时的高度，主要保存每个高度
            int height = 0, width = 0, _height = 0, __height = 0,
                    picNum = piclist.size();
            int[] heightArray = new int[picNum];
            BufferedImage buffer = null;
            List<int[]> imgRGB = new ArrayList<int[]>();
            int[] _imgRGB;
            for (int i = 0; i < picNum; i++) {
                buffer = piclist.get(i);
                heightArray[i] = _height = buffer.getHeight();// 图片高度
                if (i == 0) {
                    width = buffer.getWidth();
                }
                height += _height;
                _imgRGB = new int[width * _height];
                _imgRGB = buffer.getRGB(0, 0, width, _height, _imgRGB, 0, width);
                imgRGB.add(_imgRGB);
            }

            // 设置偏移高度为0
            _height = 0;
            // 生成新图片
            BufferedImage imageResult = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            int[] lineRGB = new int[8 * width];
            int c = new Color(128, 128, 128).getRGB();
            for (int i = 0; i < lineRGB.length; i++) {
                lineRGB[i] = c;
            }
            for (int i = 0; i < picNum; i++) {
                __height = heightArray[i];
                // 计算偏移高度
                if (i != 0)
                    _height += __height;
                imageResult.setRGB(0, _height, width, __height, imgRGB.get(i), 0, width); // 写入流中

                // 模拟页分隔
                if (i > 0) {
                    imageResult.setRGB(0, _height + 2, width, 8, lineRGB, 0, width);
                }
            }
            // 写流
            ImageIO.write(imageResult, "jpg", baos);
        } catch (Exception e) {
            System.out.println("pdf转图片异常：");
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(baos);
            try {
                pdDocument.close();
            } catch (Exception ignore) {
            }
        }

        return baos.toByteArray();
    }


    public static void main(String[] args) throws Exception {
        Map map=new HashMap<String,String>();
        map.put("SerialNumber1", "张三");
        map.put("SerialNumber2", "√");
        map.put("SerialNumber3", "dog");
        map.put("SerialNumber4", "dog");
        map.put("SerialNumber5", "dog");
        map.put("SerialNumber6", "dog");

        convertTransData(map,"","");

        System.out.println("执行完毕");

    }


}
