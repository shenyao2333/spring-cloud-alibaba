package com.sy.spring.cloud.alibaba.business.social.controller;

import com.sy.spring.cloud.alibaba.business.social.domain.BankingType;
import com.sy.spring.cloud.alibaba.business.social.service.BankingTypeService;
import com.sy.spring.cloud.alibaba.provider.basic.web.RespBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author sy
 * @date Created in 2020.7.7 21:20
 * @description 系统配置
 */
@RestController
@RequestMapping("/hiapkTypeManage")
@Api(tags = "壁纸类型管理")
public class SysController {


    @Resource
    BankingTypeService bankingTypeService;



    @ApiOperation(value = "获取系统类型列表" )
    @GetMapping("/getSysType")
    public RespBean<List<BankingType>> getSysType(Integer systemn){
        List<BankingType> bankingTypes = bankingTypeService.selectBySystemn(systemn);
        return RespBean.succeed(bankingTypes);
    }



}
