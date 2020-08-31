package com.sy.spring.cloud.alibaba.business.social.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sy.spring.cloud.alibaba.business.social.domain.dto.AddHipakDto;
import com.sy.spring.cloud.alibaba.business.social.domain.dto.GetHipakDto;
import com.sy.spring.cloud.alibaba.business.social.domain.vo.SocialImgVo;
import com.sy.spring.cloud.alibaba.business.social.service.SocialImgService;
import com.sy.spring.cloud.alibaba.provider.basic.web.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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
    public R addHiapkInfo(@RequestBody AddHipakDto addHipakDto){
        socialImgService.insert(addHipakDto);
        return R.succeed();
    }


    @ApiOperation(value = "获取壁纸列表")
    @PostMapping("/getHiapkListByParam")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "页码",name = "page",paramType = "query"),
            @ApiImplicitParam(value = "每页大小",name = "pageSize",paramType = "query")
    })
    public R<PageInfo<SocialImgVo>> getHiapkList(@RequestBody GetHipakDto getHipakDto, Integer page, Integer pageSize){
        page=page==null?1:page;
        pageSize=pageSize==null?10:pageSize;
        PageHelper.startPage(page,pageSize);
        List<SocialImgVo> list = socialImgService.getHiapkListByParam(getHipakDto);
        PageInfo<SocialImgVo> pageInfo = new PageInfo<SocialImgVo>(list);
        return R.succeed(pageInfo);
    }




}
