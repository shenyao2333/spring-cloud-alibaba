package com.sy.spring.cloud.alibaba.business.social.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.sy.spring.cloud.alibaba.business.social.mapper.HiapkSizeMapper;
import com.sy.spring.cloud.alibaba.business.social.domain.HiapkSize;
import com.sy.spring.cloud.alibaba.business.social.service.HiapkSizeService;

import java.util.List;

@Service
public class HiapkSizeServiceImpl implements HiapkSizeService{

    @Resource
    private HiapkSizeMapper hiapkSizeMapper;

    @Override
    public int insert(HiapkSize record) {
        return hiapkSizeMapper.insert(record);
    }

    @Override
    public int updateById(HiapkSize updated) {
        return hiapkSizeMapper.updateById(updated);
    }

    @Override
    public int deleteById(Long id) {
        return hiapkSizeMapper.deleteById(id);
    }

    @Override
    public List<HiapkSize> selectByAll(HiapkSize hiapkSize) {
        return hiapkSizeMapper.selectByAll(hiapkSize);
    }

}
