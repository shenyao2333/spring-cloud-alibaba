package com.sy.spring.cloud.alibaba.generator.es.esdto;

import com.sy.spring.cloud.alibaba.provider.basic.domain.auth.UserInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author sy
 * @date: 2020/8/15 13:42
 * @description
 */
public interface UserInfoRepository extends ElasticsearchRepository<UserInfo,Integer> {


    /**
     * 根据ID查询信息
     * @param id
     * @return yn
     */
    UserInfo queryUserInfoById(Integer id);


    Page<UserInfo> findByAgeBetween(double minAge, double maxAge, PageRequest of);


    /**
     * 根据关键字查询用户
     * @param userName
     * @param realName
     * @param qq
     * @param wechat
     * @param eamil
     * @param mobile
     * @param personalized
     * @return
     */
    Page<UserInfo>  findByUserNameOrRealNameOrQqOrWechatOrEmailOrMobileOrPersonalized(String userName,String realName,String qq,String wechat,String eamil,String mobile,String personalized,PageRequest of);

}
