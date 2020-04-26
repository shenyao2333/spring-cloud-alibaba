package com.sy.spring.cloud.alibaba.business.social.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.sy.spring.cloud.alibaba.business.social.domain.HiapkColour;

public interface HiapkColourMapper {
    int insertSelective(HiapkColour record);

    int updateById(@Param("updated")HiapkColour updated);

    int deleteById(@Param("id")Long id);

    List<HiapkColour> selectByAll(HiapkColour hiapkColour);




}
