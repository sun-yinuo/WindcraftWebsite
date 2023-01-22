package com.sunyinuo.userconfig.controller;

import com.sunyinuo.userconfig.service.impl.FileUploadServiceImpl;
import com.sunyinuo.userconfig.service.impl.GetFileServiceImpl;
import com.sunyinuo.userconfig.service.impl.GetUserHeadPictureServiceImpl;
import com.sunyinuo.userconfig.utils.ip.GetIp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import result.Result;

import javax.servlet.http.HttpServletRequest;

/**
 * @author sunyinuo
 */
@RestController
@RequestMapping("/userconfig/api")
@Slf4j
public class HeadPictureApiController {

    private final FileUploadServiceImpl fileUploadService;
    private final GetFileServiceImpl getFileService;
    private final GetUserHeadPictureServiceImpl getUserHeadPictureService;

    public HeadPictureApiController(FileUploadServiceImpl fileUploadService, GetFileServiceImpl getFileService, GetUserHeadPictureServiceImpl getUserHeadPictureService) {
        this.fileUploadService = fileUploadService;
        this.getFileService = getFileService;
        this.getUserHeadPictureService = getUserHeadPictureService;
    }

    @GetMapping("/getUserHeadPicture")
    public String getUserHeadPicture(HttpServletRequest request){
        String ip = GetIp.getIpAddress(request);
        return getUserHeadPictureService.getUserHeadPicture(ip);
    }

    @GetMapping("/getFile/{id}")
    public byte[] getFile(@PathVariable("id") String id) {
        return getFileService.getFile(id);
    }

    @PostMapping("/fileUpload")
    public Result fileUpload(@RequestParam("file") MultipartFile[] files ,
                             HttpServletRequest request){
        String ip = GetIp.getIpAddress(request);
        return fileUploadService.fileUpload(files,ip);
    }

}
