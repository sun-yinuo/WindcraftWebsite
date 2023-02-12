package com.sunyinuo.userconfig.service;

/**
 * @author sunyinuo
 */
public interface UserHeadGetFileService {

    /**
     * 根据id获取图片
     * @param id id
     * @return 图片Byte
     */
    byte[] getFile(String id);

}
