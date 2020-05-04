package com.sy.spring.cloud.alibaba.business.social.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.sy.spring.cloud.alibaba.business.social.domain.HiapkColour;
import com.sy.spring.cloud.alibaba.business.social.mapper.HiapkColourMapper;
import com.sy.spring.cloud.alibaba.business.social.service.HiapkColourService;

import java.util.List;

@Service
public class HiapkColourServiceImpl implements HiapkColourService{

    @Resource
    private HiapkColourMapper hiapkColourMapper;

    @Override
    public int insertSelective(HiapkColour record) {
        return hiapkColourMapper.insertSelective(record);
    }

    @Override
    public List<HiapkColour> selectByAll(HiapkColour hiapkColour) {
        return hiapkColourMapper.selectByAll(hiapkColour);
    }

    @Override
    public int updateById(HiapkColour updated) {
        return hiapkColourMapper.updateById(updated);
    }

    @Override
    public int deleteById(Long id) {
        return hiapkColourMapper.deleteById(id);
    }

    @Override
    public List<HiapkColour> select() {
        return hiapkColourMapper.select();
    }

}
