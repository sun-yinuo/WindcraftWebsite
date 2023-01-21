package com.sunyinuo.userconfig.service;

import org.springframework.web.multipart.MultipartFile;
import result.Result;

/**
 * fileUpload
 * @author sunyinuo
 */
public interface FileUploadService {

    /**
     * 图片上传
     * @param files files
     * @param ip ip
     * @return return
     */
    Result fileUpload(MultipartFile[] files, String ip);

}
