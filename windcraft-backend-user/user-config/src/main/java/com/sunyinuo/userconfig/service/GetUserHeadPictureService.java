package com.sunyinuo.userconfig.service;

/**
 * @author sunyinuo
 */
public interface GetUserHeadPictureService {

    /**
     * 根据ip获取用户头像
     * @param ip ip
     * @return 地址
     */
    String getUserHeadPicture(String ip);

}
