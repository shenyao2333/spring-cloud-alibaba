package com.sy.spring.cloud.alibaba.provider.api.dubbo.generator.es;

import com.sy.spring.cloud.alibaba.provider.basic.domain.auth.UserInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author sy
 * @date: 2020/8/15 10:22
 * @description 搜索模块里的用户信息
 */
public interface UserInfoEsService {


    /**
     * 根据id用户用户信息
     * @param userId 用户id
     * @return
     */
    UserInfo queryUserInfoById(Integer userId);


    /**
     * 根据年龄范围搜索用户信息
     * @param minAge 年龄范围-开始
     * @param maxAge 年龄范围-结束
     * @param page 页码
     * @param pageSize 数据量
     * @return
     */
    Page<UserInfo> findByAgeBetween(double minAge, double maxAge, int page,int pageSize);


    /**
     * 根据关键字搜索用户信息
     * @param keyword
     * @param page
     * @param pageSize
     * @return
     */
    Page<UserInfo> findByKeyword(String keyword,int page,int pageSize);


    void save(UserInfo user);



}
