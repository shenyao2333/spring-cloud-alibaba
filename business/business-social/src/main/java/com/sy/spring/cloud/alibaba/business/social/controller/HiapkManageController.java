package com.sy.spring.cloud.alibaba.business.social.controller;

import com.sy.spring.cloud.alibaba.business.social.domain.SocialImg;
import com.sy.spring.cloud.alibaba.business.social.service.SocialImgService;
import com.sy.spring.cloud.alibaba.module.web.RespBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

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




    @ApiOperation(value = "修改图片信息")
    @PostMapping("/addHiapkInfo")
    public RespBean addHiapkInfo(@RequestBody SocialImg socialImg){
        socialImgService.insert(socialImg);
        return RespBean.succeed();
    }


    @ApiOperation(value = "获取壁纸列表")
    @PostMapping("/getHiapkList")
    public RespBean getHiapkList(){
        return null;
    }




}
