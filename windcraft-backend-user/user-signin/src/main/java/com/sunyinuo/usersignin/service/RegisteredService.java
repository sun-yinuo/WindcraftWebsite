package com.sunyinuo.usersignin.service;

/**
 * 注册业务逻辑层
 * @author sunyinuo
 */
public interface RegisteredService {
    /**
     * 注册
     * @param userName 用户名
     * @param userPassword 密码
     * @param ip HttpServletRequest
     * @return code
     */
    Integer registered (String userName, String userPassword, String ip);
 }
