package com.sunyinuo.bancrud.service.db;

import com.sunyinuo.bancrud.model.Warning;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author sunyinuo
 */
@Mapper
public interface WarningService {

    /**
     * 获取所有
     * @return 实体类列表
     */
    List<Warning> getWarningList();
}
