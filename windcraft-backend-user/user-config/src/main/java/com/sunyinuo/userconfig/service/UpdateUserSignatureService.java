package com.sunyinuo.userconfig.service;

import result.Result;

/**
 * @author sunyinuo
 */
public interface UpdateUserSignatureService {

    /**
     * 更新用户简介
     * @param userSignature userSignature
     * @param ip ip
     * @return return
     */
    Result updateUserSignature(String userSignature, String ip);
}
