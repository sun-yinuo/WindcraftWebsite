package com.sunyinuo.reportgame.service.api;

import com.sunyinuo.reportgame.model.FileUpload;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * @author sunyinuo
 */
public interface FileUploadService {

    /**
     * 文件上传
     * @param files 文件列表
     * @param httpServletRequest Request
     * @param reportedPlayer     reportedPlayer
     * @return 返回
     */
    FileUpload fileUpload(MultipartFile[] files, String reportedPlayer , HttpServletRequest httpServletRequest);
}
