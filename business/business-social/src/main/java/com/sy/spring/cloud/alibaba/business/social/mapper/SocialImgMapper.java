package com.sy.spring.cloud.alibaba.business.social.mapper;
import com.sy.spring.cloud.alibaba.business.social.domain.dto.GetHipakDto;
import com.sy.spring.cloud.alibaba.business.social.domain.vo.SocialImgVo;
import org.apache.ibatis.annotations.Param;

import com.sy.spring.cloud.alibaba.business.social.domain.SocialImg;

import java.util.List;

public interface SocialImgMapper {
    int insert(SocialImg record);

    int insertSelective(SocialImg record);



    List<SocialImgVo> getHiapkListByParam(GetHipakDto getHipakDto);





}
