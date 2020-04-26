package com.sy.spring.cloud.alibaba.business.social.controller;

import com.sy.spring.cloud.alibaba.business.social.domain.HiapkSize;
import com.sy.spring.cloud.alibaba.business.social.service.HiapkSizeService;
import com.sy.spring.cloud.alibaba.module.web.RespBean;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author sy
 * @date Created in 2020.4.26 22:54
 * @description 壁纸管理
 */
@RestController
@RequestMapping("/hiapSizeManage")
@Api(tags = "壁纸尺寸管理")
public class HiapkSizeManageController {

    @Resource
    private HiapkSizeService hiapkSizeService;


    @PostMapping("获取壁纸尺寸列表")
    public RespBean<List<HiapkSize>> getHiapk(@RequestBody(required = false) HiapkSize hiapkSize){
        List<HiapkSize> hiapkSizes = hiapkSizeService.selectByAll(hiapkSize);
        return RespBean.succeed(hiapkSizes);
    }









}
