package com.sunyinuo.windcraftbackend.service.db.impl;

import com.sunyinuo.windcraftbackend.mapper.ProhibitMapper;
import com.sunyinuo.windcraftbackend.model.Prohibit;
import com.sunyinuo.windcraftbackend.service.db.ProhibitService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author sunyinuo
 */
@Service
public class ProhibitServiceImpl implements ProhibitService {

    @Resource
    private ProhibitMapper prohibitMapper;

    /**
     * 获取所有
     * @return 实体类列表
     */
    @Override
    public List<Prohibit> getProhibitList() {
        return prohibitMapper.getProhibitList();
    }
}
