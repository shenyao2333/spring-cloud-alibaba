package com.sy.spring.cloud.alibaba.business.social.controller;

import com.sy.spring.cloud.alibaba.provider.basic.web.RespBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author sy
 * @date Created in 2020.4.29 22:48
 * @description 壁纸类型管理
 */
@RestController
@RequestMapping("/hiapkTypeManage")
@Api(tags = "壁纸类型管理")
public class HiapkTypeManageController {


    @PostMapping("getHiapkTypes")
    @ApiOperation(value = "获取壁纸类型系列表",notes = "可根据条件查询，传什么值就以该值做条件查询")
    public RespBean getHiapk(){
       return null;
    }

    @PostMapping("addHiapkType")
    @ApiOperation(value = "添加壁纸类型",notes = "")
    public RespBean addHiapkSize(){
        return RespBean.succeed("添加成功");
    }



}
