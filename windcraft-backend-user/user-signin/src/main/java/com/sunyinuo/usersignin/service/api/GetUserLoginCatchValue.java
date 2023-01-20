package com.sunyinuo.usersignin.service.api;

/**
 * @author sunyinuo
 */
public interface GetUserLoginCatchValue {

    /**
     * 根据ip获取登陆缓存信息
     * @param ip ip
     * @return 信息字符串
     */
    String getUserLoginCatchValue(String ip);
}
