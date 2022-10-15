package com.sunyinuo.windcraftbackendreport.controller;

import com.sunyinuo.windcraftbackendreport.model.FileUpload;
import com.sunyinuo.windcraftbackendreport.service.api.impl.FileUploadServiceImpl;
import com.sunyinuo.windcraftbackendreport.service.api.impl.GetFileServiceImpl;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * api控制器
 * @author sunyinuo
 */
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*",maxAge = 3600)
public class ApiController {

    private final FileUploadServiceImpl fileUploadService;
    private final GetFileServiceImpl getFileService;

    public ApiController(FileUploadServiceImpl fileUploadService, GetFileServiceImpl getFileService) {
        this.fileUploadService = fileUploadService;
        this.getFileService = getFileService;
    }


    /**
     * 接收文件
     * @param files 文件
     * @return 文件信息
     */
    @PostMapping("/fileUpload")
    public FileUpload fileUpload(@RequestParam("file") MultipartFile[] files ,
                                 @RequestParam("reportedPlayer") String reportedPlayer,
                                 HttpServletRequest request){

        return fileUploadService.fileUpload(files,reportedPlayer,request);
    }

    @GetMapping("/getFile/{id}")
    public byte[] getFile(@PathVariable("id") String id) {
        return getFileService.getFile(id);
    }


}
