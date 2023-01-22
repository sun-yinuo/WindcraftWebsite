package com.sunyinuo.userconfig.service;

import result.Result;

/**
 * @author sunyinuo
 */
public interface UserLogOutService {


    /**
     * 用户注销
     * @param confirmUser 确认用户名
     * @param ip ip
     * @return 返回
     */
    Result userLogOut(String confirmUser, String ip);
}
