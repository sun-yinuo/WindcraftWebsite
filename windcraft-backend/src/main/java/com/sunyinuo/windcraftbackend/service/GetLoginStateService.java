package com.sunyinuo.windcraftbackend.service;


/**
 * 获取登陆状态
 * @author sunyinuo
 */
public interface GetLoginStateService {

    /**
     * 获取所有登陆成功用户的缓存信息
     * @param ip ip
     * @return 登陆状态
     */
    boolean getLoginState(String ip);

}
