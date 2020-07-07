package com.sy.spring.cloud.alibaba.business.social.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.sy.spring.cloud.alibaba.business.social.domain.BankingType;
import com.sy.spring.cloud.alibaba.business.social.mapper.BankingTypeMapper;
import com.sy.spring.cloud.alibaba.business.social.service.BankingTypeService;

import java.util.List;

@Service
public class BankingTypeServiceImpl implements BankingTypeService{

    @Resource
    private BankingTypeMapper bankingTypeMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return bankingTypeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(BankingType record) {
        return bankingTypeMapper.insert(record);
    }

    @Override
    public int insertSelective(BankingType record) {
        return bankingTypeMapper.insertSelective(record);
    }

    @Override
    public BankingType selectByPrimaryKey(Integer id) {
        return bankingTypeMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(BankingType record) {
        return bankingTypeMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(BankingType record) {
        return bankingTypeMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<BankingType> selectBySystemn(Integer systemn) {
        return bankingTypeMapper.selectBySystemn(systemn);
    }

}
