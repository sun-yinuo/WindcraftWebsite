package com.sunyinuo.bancrud.service.api;

import com.sunyinuo.bancrud.model.Prohibit;

import java.util.List;

/**
 * @author sunyinuo
 */
public interface GetProhibitListService {
    /**
     * 获取禁言玩家列表
     * @return 列表
     */
    List<Prohibit> getProhibitList();
}
