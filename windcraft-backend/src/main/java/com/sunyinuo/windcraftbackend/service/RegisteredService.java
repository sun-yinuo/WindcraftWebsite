package com.sunyinuo.windcraftbackend.service;

import com.sunyinuo.windcraftbackend.model.User;

/**
 * 注册业务逻辑层
 * @author sunyinuo
 */
public interface RegisteredService {
    /**
     * 注册
     * @param userName 用户名
     * @param userPassword 密码
     * @return code
     */
    Integer registered (String userName, String userPassword);
 }
