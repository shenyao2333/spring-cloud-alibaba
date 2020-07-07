package com.sy.spring.cloud.alibaba.business.social.mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import com.sy.spring.cloud.alibaba.business.social.domain.BankingType;

public interface BankingTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BankingType record);

    int insertSelective(BankingType record);

    BankingType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BankingType record);

    int updateByPrimaryKey(BankingType record);


    List<BankingType> selectBySystemn(@Param("systemn")Integer systemn);


}
