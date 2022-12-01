package com.sunyinuo.bancrud.service.api;

import com.sunyinuo.bancrud.model.Warning;

import java.util.List;

/**
 * @author sunyinuo
 */
public interface GetWaringListService {
    /**
     * 获取被警告玩家列表
     * @return 列表
     */
    List<Warning> getWaringList();
}
