package com.sy.spring.cloud.alibaba.business.social.service;

import com.sy.spring.cloud.alibaba.business.social.domain.HiapkColour;

import java.util.List;

public interface HiapkColourService{


    int insertSelective(HiapkColour record);


    List<HiapkColour> selectByAll(HiapkColour hiapkColour);


    int updateById(HiapkColour updated);

    int deleteById(Long id);

    List<HiapkColour> select();
}
