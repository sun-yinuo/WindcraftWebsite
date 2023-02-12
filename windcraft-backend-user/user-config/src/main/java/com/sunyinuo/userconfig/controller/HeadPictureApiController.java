package com.sunyinuo.userconfig.controller;

import com.sunyinuo.userconfig.service.impl.UserHeadFileUploadServiceImpl;
import com.sunyinuo.userconfig.service.impl.UserHeadGetFileServiceImpl;
import com.sunyinuo.userconfig.service.impl.UserHeadGetUserHeadPictureServiceImpl;
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

    private final UserHeadFileUploadServiceImpl fileUploadService;
    private final UserHeadGetFileServiceImpl getFileService;
    private final UserHeadGetUserHeadPictureServiceImpl getUserHeadPictureService;

    public HeadPictureApiController(UserHeadFileUploadServiceImpl fileUploadService, UserHeadGetFileServiceImpl getFileService, UserHeadGetUserHeadPictureServiceImpl getUserHeadPictureService) {
        this.fileUploadService = fileUploadService;
        this.getFileService = getFileService;
        this.getUserHeadPictureService = getUserHeadPictureService;
    }

    @GetMapping("/userHeadGetUserHeadPicture")
    public String userHeadGetUserHeadPicture(HttpServletRequest request){
        String ip = GetIp.getIpAddress(request);
        return getUserHeadPictureService.getUserHeadPicture(ip);
    }

    @GetMapping("/userHeadGetFile/{id}")
    public byte[] userHeadGetFile(@PathVariable("id") String id) {
        return getFileService.getFile(id);
    }

    @PostMapping("/userHeadFileUpload")
    public Result userHeadFileUpload(@RequestParam("file") MultipartFile[] files ,
                             HttpServletRequest request){
        String ip = GetIp.getIpAddress(request);
        return fileUploadService.fileUpload(files,ip);
    }

}
