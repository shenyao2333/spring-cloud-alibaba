package com.sy.spring.cloud.alibaba.business.social.service.impl;

import com.sy.spring.cloud.alibaba.business.social.domain.dto.AddHipakDto;
import com.sy.spring.cloud.alibaba.business.social.domain.dto.GetHipakDto;
import com.sy.spring.cloud.alibaba.business.social.domain.vo.SocialImgVo;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.sy.spring.cloud.alibaba.business.social.domain.SocialImg;
import com.sy.spring.cloud.alibaba.business.social.mapper.SocialImgMapper;
import com.sy.spring.cloud.alibaba.business.social.service.SocialImgService;

import java.util.List;

@Service
public class SocialImgServiceImpl implements SocialImgService{

    @Resource
    private SocialImgMapper socialImgMapper;

    @Override
    public int insert(AddHipakDto addHipakDto) {
        return socialImgMapper.insert(addHipakDto);
    }



    @Override
    public int insertSelective(SocialImg record) {
        return socialImgMapper.insertSelective(record);
    }



    @Override
    public List<SocialImgVo> getHiapkListByParam(GetHipakDto getHipakDto) {
        List<SocialImgVo> list =  socialImgMapper.getHiapkListByParam(getHipakDto);
        return list;
    }

}
