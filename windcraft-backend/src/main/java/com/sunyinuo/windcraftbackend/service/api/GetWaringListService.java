package com.sunyinuo.windcraftbackend.service.api;

import com.sunyinuo.windcraftbackend.model.Warning;

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
