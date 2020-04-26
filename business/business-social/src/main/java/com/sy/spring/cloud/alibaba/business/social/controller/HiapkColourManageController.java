package com.sy.spring.cloud.alibaba.business.social.controller;

import com.sy.spring.cloud.alibaba.business.social.domain.HiapkColour;
import com.sy.spring.cloud.alibaba.business.social.domain.HiapkSize;
import com.sy.spring.cloud.alibaba.business.social.service.HiapkColourService;
import com.sy.spring.cloud.alibaba.module.web.RespBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author sy
 * @date Created in 2020.4.26 23:16
 * @description 壁纸色系管理
 */
@RestController
@RequestMapping("/hiapkColourManage")
@Api(tags = "壁纸色系管理")
public class HiapkColourManageController {


    @Resource
    private HiapkColourService hiapkColourService;

    @PostMapping("getHiapkColours")
    @ApiOperation(value = "获取壁纸色系列表",notes = "可根据条件查询，传什么值就以该值做条件查询")
    public RespBean<List<HiapkColour>> getHiapk(@RequestBody(required = false) HiapkColour hiapkColour){
        List<HiapkColour> hiapkColours = hiapkColourService.selectByAll(hiapkColour);
        return RespBean.succeed(hiapkColours);
    }

    @PostMapping("updateColourById")
    @ApiOperation(value = "修改壁纸色系信息",notes = "根据主键id修改信息")
    public RespBean update(@RequestBody HiapkColour hiapkColour){
        return null;
    }







}
