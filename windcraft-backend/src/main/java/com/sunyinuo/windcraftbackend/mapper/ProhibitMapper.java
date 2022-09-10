package com.sunyinuo.windcraftbackend.mapper;

import com.sunyinuo.windcraftbackend.model.Prohibit;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 *
 * @author sunyinuo
 */
@Mapper
public interface ProhibitMapper {
    /**
     * 获取所有
     * @return 实体类列表
     */
    List<Prohibit> getProhibitList();
}
