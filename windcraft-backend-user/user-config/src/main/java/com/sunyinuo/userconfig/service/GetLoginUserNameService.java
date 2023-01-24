package com.sunyinuo.userconfig.service;

/**
 * @author sunyinuo
 */
public interface GetLoginUserNameService {

    /**
     * 获取登陆用户名
     * @param ip ip
     * @return re
     */
    String getLoginUserName(String ip);
}
