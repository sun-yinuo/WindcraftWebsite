package com.sunyinuo.usersignin.service.api.impl;

import com.sunyinuo.usersignin.service.api.GetUserLoginCatchValue;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @author sunyinuo
 */
@Service
public class GetUserLoginCatchValueImpl implements GetUserLoginCatchValue {

    private final RedisTemplate<Object, Object> redisTemplate;

    public GetUserLoginCatchValueImpl(RedisTemplate<Object, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    /**
     * 根据ip获取登陆缓存信息
     * @param ip ip
     * @return 信息字符串
     */
    @Override
    public String getUserLoginCatchValue(String ip) {
        return (String) redisTemplate.opsForValue().get(ip);
    }
}
