package com.sy.spring.cloud.alibaba.business.social.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.sy.spring.cloud.alibaba.business.social.domain.HiapkSize;

public interface HiapkSizeMapper {
    int insert(HiapkSize record);

    int updateById(@Param("updated")HiapkSize updated);

    int deleteById(@Param("id")Long id);

	List<HiapkSize> selectByAll(HiapkSize hiapkSize);



}
