package com.sy.spring.cloud.alibaba.business.social.controller;

import com.sy.spring.cloud.alibaba.business.social.service.SocialImgService;
import com.sy.spring.cloud.alibaba.module.web.RespBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.File;

/**
 * @author sy
 * @date: 2020/4/27 11:35
 * @description 壁纸管理
 */
@RestController
@RequestMapping("/hiapkManage")
@Api(tags = "壁纸管理")
public class HiapkManageController  {


    @Resource
    private SocialImgService socialImgService;


    @ApiOperation(value = "上传图片")
    public RespBean uploadImg(File file){
        return null;
    }


    @ApiOperation(value = "修改图片信息")
    public RespBean updateHiapkInfo(){
        return null;
    }


    @ApiOperation(value = "获取壁纸列表")
    public RespBean getHiapkList(){
        return null;
    }




}
