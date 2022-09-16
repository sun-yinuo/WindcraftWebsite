package com.sunyinuo.windcraftbackend.service.db;

import com.sunyinuo.windcraftbackend.model.Warning;

import java.util.List;

/**
 * @author sunyinuo
 */
public interface WarningService {

    /**
     * 获取所有
     * @return 实体类列表
     */
    List<Warning> getWarningList();
}
