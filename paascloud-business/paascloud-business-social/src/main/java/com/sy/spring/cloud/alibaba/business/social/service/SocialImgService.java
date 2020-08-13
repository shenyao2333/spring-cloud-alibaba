package com.sy.spring.cloud.alibaba.business.social.service;

import com.sy.spring.cloud.alibaba.business.social.domain.SocialImg;
import com.sy.spring.cloud.alibaba.business.social.domain.dto.AddHipakDto;
import com.sy.spring.cloud.alibaba.business.social.domain.dto.GetHipakDto;
import com.sy.spring.cloud.alibaba.business.social.domain.vo.SocialImgVo;

import java.util.List;

public interface SocialImgService{


    int insert(AddHipakDto addHipakDto);

    int insertSelective(SocialImg record);


    /**
     * 根据参数查找图片列表
     * @param getHipakDto
     * @return
     */
    List<SocialImgVo> getHiapkListByParam(GetHipakDto getHipakDto);
}
