package com.sunyinuo.bancrud.service.api.impl;

import com.sunyinuo.bancrud.model.Warning;
import com.sunyinuo.bancrud.service.api.GetWaringListService;
import com.sunyinuo.bancrud.service.db.impl.WarningServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sunyinuo
 */
@Service
public class GetWaringListServiceImpl implements GetWaringListService {

    private final WarningServiceImpl warningService;

    public GetWaringListServiceImpl(WarningServiceImpl warningService) {
        this.warningService = warningService;
    }

    /**
     * 获取被警告玩家列表
     * @return 列表
     */
    @Override
    public List<Warning> getWaringList() {
        return warningService.getWarningList();
    }
}
