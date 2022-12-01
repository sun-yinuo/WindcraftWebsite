package com.sunyinuo.bancrud.service.api;

import com.sunyinuo.bancrud.model.Ban;

import java.util.List;

/**
 * GetBanListService层
 * @author sunyinuo
 */
public interface GetBanListService {
    /**
     * 获取所有被ban用户的信息
     * @return 实体类集合
     */
    List<Ban> getBanList();
}
