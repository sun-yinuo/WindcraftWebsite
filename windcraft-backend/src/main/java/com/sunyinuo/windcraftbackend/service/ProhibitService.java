package com.sunyinuo.windcraftbackend.service;

import com.sunyinuo.windcraftbackend.model.Prohibit;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author sunyinuo
 */
@Mapper
public interface ProhibitService {

    /**
     * 获取所有
     * @return 实体类列表
     */
    List<Prohibit> getProhibitList();

}
