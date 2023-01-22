package com.sunyinuo.userconfig.service;

import result.Result;

/**
 * @author sunyinuo
 */
public interface UpdateUserNameService {

    /**
     * 更新用户名
     * @param newUserName 新用户名
     * @param ip ip
     * @return 返回
     */
    Result updateUserName (String newUserName, String ip);

}
