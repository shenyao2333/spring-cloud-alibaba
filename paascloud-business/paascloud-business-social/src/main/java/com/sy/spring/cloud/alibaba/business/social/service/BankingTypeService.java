package com.sy.spring.cloud.alibaba.business.social.service;

import com.sy.spring.cloud.alibaba.business.social.domain.BankingType;

import java.util.List;

public interface BankingTypeService{


    int deleteByPrimaryKey(Integer id);

    int insert(BankingType record);

    int insertSelective(BankingType record);

    BankingType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BankingType record);

    int updateByPrimaryKey(BankingType record);


    List<BankingType> selectBySystemn(Integer systemn);

}
