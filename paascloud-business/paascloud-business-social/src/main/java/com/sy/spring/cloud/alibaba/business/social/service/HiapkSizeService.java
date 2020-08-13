package com.sy.spring.cloud.alibaba.business.social.service;

import com.sy.spring.cloud.alibaba.business.social.domain.HiapkSize;

import java.util.List;

public interface HiapkSizeService{


    int insert(HiapkSize record);


    int updateById(HiapkSize updated);

    int deleteById(Long id);

    List<HiapkSize> selectByAll(HiapkSize hiapkSize);

}
