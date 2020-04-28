package com.sy.spring.cloud.alibaba.business.social.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.sy.spring.cloud.alibaba.business.social.domain.SocialImg;
import com.sy.spring.cloud.alibaba.business.social.mapper.SocialImgMapper;
import com.sy.spring.cloud.alibaba.business.social.service.SocialImgService;
@Service
public class SocialImgServiceImpl implements SocialImgService{

    @Resource
    private SocialImgMapper socialImgMapper;

    @Override
    public int insert(SocialImg record) {
        return socialImgMapper.insert(record);
    }

    @Override
    public int insertSelective(SocialImg record) {
        return socialImgMapper.insertSelective(record);
    }

}
