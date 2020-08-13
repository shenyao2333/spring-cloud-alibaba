package com.sy.spring.cloud.alibaba.business.social.controller;

import com.sy.spring.cloud.alibaba.business.social.domain.HiapkColour;
import com.sy.spring.cloud.alibaba.business.social.domain.HiapkSize;
import com.sy.spring.cloud.alibaba.business.social.domain.dto.SocialAddColourDto;
import com.sy.spring.cloud.alibaba.business.social.service.HiapkSizeService;
import com.sy.spring.cloud.alibaba.module.web.RespBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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


    @PostMapping("getHiapkSizes")
    @ApiOperation(value = "获取壁纸色系列表",notes = "可根据条件查询，传什么值就以该值做条件查询")
    public RespBean<List<HiapkSize>> getHiapk(@RequestBody(required = false) HiapkSize hiapkSize){
        List<HiapkSize> hiapkSizes = hiapkSizeService.selectByAll(hiapkSize);
        return RespBean.succeed(hiapkSizes);
    }


    @PostMapping("updateColourById")
    @ApiOperation(value = "修改壁纸色系信息",notes = "根据主键id修改信息")
    public RespBean updateColourById(@RequestBody HiapkSize hiapkSize){
        if (hiapkSize.getId()==null||0==(hiapkSize.getId())){
            return RespBean.fail(RespBean.CodeStatus.REQUEST,"修改主键id不能为空");
        }
        hiapkSizeService.updateById(hiapkSize);
        return RespBean.succeed("修改成功");
    }



    @PostMapping("addHiapkSize")
    @ApiOperation(value = "添加壁纸色系",notes = "")
    public RespBean addHiapkSize(@RequestBody HiapkSize hiapkSize){
        hiapkSizeService.insert(hiapkSize);
        return RespBean.succeed("添加成功");
    }



    @DeleteMapping("/deleteHiapkColourById")
    @ApiOperation(value = "根据主键id删除色系",notes = "")
    public RespBean deleteHiapkColourById(Long id){
        hiapkSizeService.deleteById(id);
        return RespBean.succeed("删除成功");
    }







}
