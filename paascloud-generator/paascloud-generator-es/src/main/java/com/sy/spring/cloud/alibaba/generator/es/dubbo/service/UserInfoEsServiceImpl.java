package com.sy.spring.cloud.alibaba.generator.es.dubbo.service;

import com.sy.spring.cloud.alibaba.generator.es.esdto.UserInfoRepository;
import com.sy.spring.cloud.alibaba.provider.api.dubbo.generator.es.UserInfoEsService;
import com.sy.spring.cloud.alibaba.provider.basic.domain.auth.UserInfo;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;


/**
 * @author sy
 * @date: 2020/8/15 10:31
 * @description
 */
@Path("/user")
@Service(version = "1.0.0", protocol = { "dubbo" })
public class UserInfoEsServiceImpl implements UserInfoEsService {


    @Resource
    private UserInfoRepository userInfoRepository;


    @Override
    @Path("queryUserInfoById")
    @GET
    public UserInfo queryUserInfoById(Integer userId) {
        return userInfoRepository.queryUserInfoById(userId);
    }



    @Path("findByAgeBetween")
    @GET
    @Override
    public Page<UserInfo> findByAgeBetween(double minAge, double maxAge, int page, int pageSize) {
        return  userInfoRepository.findByAgeBetween(minAge, maxAge, PageRequest.of(page,pageSize));
    }


    @Path("findByKeyword")
    @GET
    @Override
    public Page<UserInfo> findByKeyword(String keyword, int page, int pageSize) {
        return userInfoRepository.findByUserNameOrRealNameOrQqOrWechatOrEmailOrMobileOrPersonalized(keyword,keyword,keyword,keyword,keyword,keyword,keyword,PageRequest.of(page,pageSize));
    }


    @Path("save")
    @POST
    @Override
    public void save(UserInfo userInfo){
        userInfoRepository.save(userInfo);
    }







}
