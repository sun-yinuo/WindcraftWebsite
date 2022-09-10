package com.sunyinuo.windcraftbackend.service.impl;

import com.sunyinuo.windcraftbackend.model.Ban;
import com.sunyinuo.windcraftbackend.service.GetBanListService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * GetBanListService层实现类
 * @author sunyinuo
 */
@Service
public class GetBanListServiceImpl implements GetBanListService {
    private final BanServiceImpl banService;

    public GetBanListServiceImpl(BanServiceImpl banService) {
        this.banService = banService;
    }

    /**
     * 获取所有被ban用户的信息
     * @return 实体类集合
     */
    @Override
    public List<Ban> getBanList() {
        return banService.getBanList();
    }
}
