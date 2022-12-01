package com.sunyinuo.bancrud.mapper;

import com.sunyinuo.bancrud.model.Prohibit;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Prohibit表mapper
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
