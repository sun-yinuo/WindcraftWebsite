package com.sunyinuo.windcraftbackend.mapper;

import com.sunyinuo.windcraftbackend.model.Warning;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * warning表mapper
 * @author sunyinuo
 */
@Mapper
public interface WarningMapper {

    /**
     * 获取所有
     * @return 实体类列表
     */
    List<Warning> getWarningList();

}
