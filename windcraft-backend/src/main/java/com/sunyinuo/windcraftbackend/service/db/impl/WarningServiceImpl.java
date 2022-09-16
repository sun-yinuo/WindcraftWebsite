package com.sunyinuo.windcraftbackend.service.db.impl;

import com.sunyinuo.windcraftbackend.mapper.WarningMapper;
import com.sunyinuo.windcraftbackend.model.Warning;
import com.sunyinuo.windcraftbackend.service.db.WarningService;
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
