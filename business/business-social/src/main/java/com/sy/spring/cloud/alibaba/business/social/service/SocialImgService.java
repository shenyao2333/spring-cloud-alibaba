package com.sy.spring.cloud.alibaba.business.social.service;

import com.sy.spring.cloud.alibaba.business.social.domain.SocialImg;
public interface SocialImgService{


    int insert(SocialImg record);

    int insertSelective(SocialImg record);

}
