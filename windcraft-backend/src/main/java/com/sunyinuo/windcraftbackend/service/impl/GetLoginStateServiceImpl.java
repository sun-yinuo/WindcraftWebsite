package com.sunyinuo.windcraftbackend.service.impl;

import com.sunyinuo.windcraftbackend.service.GetLoginStateService;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @author sunyinuo
 */
@Service
public class GetLoginStateServiceImpl implements GetLoginStateService {

    private final StringRedisTemplate redisTemplate;

    public GetLoginStateServiceImpl (StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    private static final String PREFIX = "loginState";
    private static final String SEPARATION = "::";

    /**
     * 获取所有登陆成功用户的缓存信息
     * @param ip ip
     * @return 登陆状态
     */
    @Override
    public boolean getLoginState(String ip) {
        return Boolean.TRUE.equals(redisTemplate.hasKey(PREFIX + SEPARATION + ip));
    }
}
