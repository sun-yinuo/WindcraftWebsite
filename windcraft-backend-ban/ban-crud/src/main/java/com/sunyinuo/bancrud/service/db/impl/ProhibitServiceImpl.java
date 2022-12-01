package com.sunyinuo.bancrud.service.db.impl;

import com.sunyinuo.bancrud.mapper.ProhibitMapper;
import com.sunyinuo.bancrud.model.Prohibit;
import com.sunyinuo.bancrud.service.db.ProhibitService;
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
