package com.sunyinuo.userconfigappendusercover.service;

import org.springframework.web.multipart.MultipartFile;
import result.Result;

/**
 * @author sunyinuo
 */
public interface UserCoverFileUploadService {
    /**
     * 图片上传
     * @param files files
     * @param ip ip
     * @return return
     */
    Result userCoverFileUpload(MultipartFile[] files, String ip);
}
