package com.sunyinuo.windcraftbackendreport.controller.api;

import com.sunyinuo.windcraftbackendreport.service.api.impl.FileUploadServiceImpl;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author sunyinuo
 */
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*",maxAge = 3600)
public class FileUploadController {

    private final FileUploadServiceImpl fileUploadService;

    public FileUploadController(FileUploadServiceImpl fileUploadService) {
        this.fileUploadService = fileUploadService;
    }

    /**
     * 接收文件
     * @param files 文件
     * @return 返回
     */
    @PostMapping("/fileUpload")
    public Integer fileUpload(@RequestParam("file") MultipartFile[] files){
        return fileUploadService.fileUpload(files);
    }

}
