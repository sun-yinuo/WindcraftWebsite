package com.sunyinuo.windcraftbackend.service;

import com.sunyinuo.windcraftbackend.model.User;

/**
 * 登陆业务逻辑层
 * @author sunyinuo
 */
public interface LoginService {
    /**
     * 登陆
     * @param userName 用户名
     * @param userPassword 密码
     * @return code
     */
    Integer login (String userName, String userPassword);
}
