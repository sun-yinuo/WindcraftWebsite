package com.sunyinuo.windcraftbackend.service.api.impl;

import com.sunyinuo.windcraftbackend.model.Prohibit;
import com.sunyinuo.windcraftbackend.service.api.GetProhibitListService;
import com.sunyinuo.windcraftbackend.service.db.impl.ProhibitServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sunyinuo
 */
@Service
public class GetProhibitListServiceImpl implements GetProhibitListService {
    private final ProhibitServiceImpl prohibitService;


    public GetProhibitListServiceImpl(ProhibitServiceImpl prohibitService) {
        this.prohibitService = prohibitService;
    }

    /**
     * 获取禁言玩家列表
     * @return 列表
     */
    @Override
    public List<Prohibit> getProhibitList() {
        return prohibitService.getProhibitList();
    }
}
