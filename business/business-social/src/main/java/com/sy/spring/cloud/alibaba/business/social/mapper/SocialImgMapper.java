package com.sy.spring.cloud.alibaba.business.social.mapper;

import com.sy.spring.cloud.alibaba.business.social.domain.SocialImg;

public interface SocialImgMapper {
    int insert(SocialImg record);

    int insertSelective(SocialImg record);
}