package com.sy.spring.cloud.alibaba.business.social.controller;

import com.sy.spring.cloud.alibaba.provider.api.dubbo.TestDobbo;
import com.sy.spring.cloud.alibaba.provider.api.feign.businessgoods.TestFeign2;
import com.sy.spring.cloud.alibaba.business.social.service.ApiService;
import com.sy.spring.cloud.alibaba.provider.basic.utils.OSSFileUtil;
import com.sy.spring.cloud.alibaba.provider.basic.web.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * @author sy
 * @date Created in 2020.4.27 21:51
 * @description 公开
 */
@RestController
@RequestMapping("/api")
@Api(tags = "公用接口")
@Slf4j
public class ApiController {

    @Resource
    private ApiService apiService;

    @Reference
    private TestDobbo testDobbo;

    @Resource
    private TestFeign2 testFeign2;


    @GetMapping("/test")
    @ApiOperation(value = "文件上传,返回图片路径")
    public R uploadFile(MultipartFile file){
        String s = OSSFileUtil.upload(file,null);
        return R.succeed(s);
    }



    @GetMapping("/testDobbo")
    public R test(){
        return R.succeed(testDobbo.echo("生产者调用"));
    }

    @GetMapping("/testFeign")
    public R testFeign(String name){
        System.out.println("======>"+System.currentTimeMillis());
        return R.succeed(name+" : 成功");
    }


    @GetMapping("/test2")
    public R test2(){
        R respBean = testFeign2.testFeign();
        System.out.println(respBean);
        return respBean;
    }








}
