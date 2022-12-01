package com.sunyinuo.usersignin.service;

/**
 * 登陆业务逻辑层
 * @author sunyinuo
 */
public interface LoginService {
    /**
     * 登陆
     * @param userName 用户名
     * @param userPassword 密码
     * @param ip ip(缓存需要)
     * @return code
     */
    Integer login (String userName, String userPassword, String ip);
}
