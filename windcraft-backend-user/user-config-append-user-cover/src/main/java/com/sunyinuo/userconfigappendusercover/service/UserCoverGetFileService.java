package com.sunyinuo.userconfigappendusercover.service;

/**
 * @author sunyinuo
 */
public interface UserCoverGetFileService {
    /**
     * 根据id获取图片
     * @param id id
     * @return 图片Byte
     */
    byte[] userCoverGetFile(String id);
}
