package com.sunyinuo.windcraftbackendreport.service.api;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author sunyinuo
 */
public interface FileUploadService {

    /**
     * 文件上传
     * @param files 文件列表
     * @return 返回
     */
    Integer fileUpload(MultipartFile[] files);

}
