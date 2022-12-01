package com.sunyinuo.bancrud.service.db.impl;

import com.sunyinuo.bancrud.mapper.WarningMapper;
import com.sunyinuo.bancrud.model.Warning;
import com.sunyinuo.bancrud.service.db.WarningService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author sunyinuo
 */
@Service
public class WarningServiceImpl implements WarningService {

    @Resource
    private WarningMapper warningMapper;

    /**
     * 获取所有
     * @return 实体类列表
     */
    @Override
    public List<Warning> getWarningList() {
        return warningMapper.getWarningList();
    }
}
