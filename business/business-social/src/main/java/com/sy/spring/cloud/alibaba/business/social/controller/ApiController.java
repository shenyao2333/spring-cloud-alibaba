package com.sy.spring.cloud.alibaba.business.social.controller;

import com.sy.spring.cloud.alibaba.business.social.service.ApiService;
import com.sy.spring.cloud.alibaba.module.utils.UploadFileUtil;
import com.sy.spring.cloud.alibaba.module.web.RespBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;

/**
 * @author sy
 * @date Created in 2020.4.27 21:51
 * @description 公开
 */
@RestController
@RequestMapping("/api")
@Api(tags = "公用接口")
public class ApiController {

    @Resource
    private ApiService apiService;


    @GetMapping("/test")
    @ApiOperation(value = "文件上传,返回图片路径")
    public RespBean uploadFile(MultipartFile file){
        String s = UploadFileUtil.upload(file);
        return RespBean.succeed(s);
    }













}