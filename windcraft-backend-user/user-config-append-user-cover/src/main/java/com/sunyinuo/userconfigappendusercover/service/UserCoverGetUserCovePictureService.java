package com.sunyinuo.userconfigappendusercover.service;

/**
 * @author sunyinuo
 */
public interface UserCoverGetUserCovePictureService {

    /**
     * 根据ip获取用户封面
     * @param ip ip
     * @return 地址
     */
    String getUserHeadPicture(String ip);
}
