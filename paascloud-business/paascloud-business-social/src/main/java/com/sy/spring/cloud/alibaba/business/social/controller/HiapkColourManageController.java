package com.sy.spring.cloud.alibaba.business.social.controller;

import com.sy.spring.cloud.alibaba.business.social.domain.HiapkColour;
import com.sy.spring.cloud.alibaba.business.social.domain.dto.SocialAddColourDto;
import com.sy.spring.cloud.alibaba.business.social.service.HiapkColourService;
import com.sy.spring.cloud.alibaba.provider.basic.web.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

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


    @GetMapping("/getHiapks")
    public R<List<HiapkColour>> getHiapk(){
        return R.succeed(hiapkColourService.select());
    }

    @PostMapping("getHiapksByParam")
    @ApiOperation(value = "根据参数查询色系列表",notes = "可根据条件查询，传什么值就以该值做条件查询")
    public R<List<HiapkColour>> getHiapksByParam(@RequestBody(required = false) HiapkColour hiapkColour){
        List<HiapkColour> hiapkColours = hiapkColourService.selectByAll(hiapkColour);
        return R.succeed(hiapkColours);
    }



    @PostMapping("updateColourById")
    @ApiOperation(value = "修改壁纸色系信息",notes = "根据主键id修改信息")
    public R updateColourById(@RequestBody HiapkColour hiapkColour){
        if (hiapkColour.getId()==null||"".equals(hiapkColour.getId())){
            return R.fail(R.CodeStatus.REQUEST,"修改主键id不能为空");
        }
        hiapkColourService.updateById(hiapkColour);
        return R.succeed("修改成功");
    }



    @PostMapping("addHiapkColour")
    @ApiOperation(value = "添加壁纸色系",notes = "")
    public R addHiapkColour(@RequestBody SocialAddColourDto socialAddColourDto){
        hiapkColourService.insertSelective(socialAddColourDto);
        return R.succeed("添加成功");
    }



    @DeleteMapping("/deleteHiapkColourById")
    @ApiOperation(value = "根据主键id删除色系",notes = "")
    public R deleteHiapkColourById(Long id){
        hiapkColourService.deleteById(id);
        return R.succeed("删除成功");
    }











}
