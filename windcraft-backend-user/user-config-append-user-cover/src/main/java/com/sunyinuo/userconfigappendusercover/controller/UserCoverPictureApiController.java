package com.sunyinuo.userconfigappendusercover.controller;

import com.sunyinuo.userconfigappendusercover.service.impl.UserCoverFileUploadServiceImpl;
import com.sunyinuo.userconfigappendusercover.service.impl.UserCoverGetFileServiceImpl;
import com.sunyinuo.userconfigappendusercover.service.impl.UserCoverGetUserCovePictureServiceImpl;
import com.sunyinuo.userconfigappendusercover.utils.ip.GetIp;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import result.Result;

import javax.servlet.http.HttpServletRequest;

/**
 * @author sunyinuo
 */
@RestController
@RequestMapping("/userconfigappendusercover/api")
public class UserCoverPictureApiController {

    private final UserCoverGetUserCovePictureServiceImpl userCoverGetUserCovePictureService;
    private final UserCoverGetFileServiceImpl userCoverGetFileService;
    private final UserCoverFileUploadServiceImpl userCoverFileUploadService;

    public UserCoverPictureApiController(UserCoverGetUserCovePictureServiceImpl userCoverGetUserCovePictureService, UserCoverGetFileServiceImpl userCoverGetFileService, UserCoverFileUploadServiceImpl userCoverFileUploadService) {
        this.userCoverGetUserCovePictureService = userCoverGetUserCovePictureService;
        this.userCoverGetFileService = userCoverGetFileService;
        this.userCoverFileUploadService = userCoverFileUploadService;
    }


    @GetMapping("/userCoverGetUserCovePicture")
    public String userCoverGetUserCovePicture(HttpServletRequest request){
        String ip = GetIp.getIpAddress(request);
        return userCoverGetUserCovePictureService.getUserHeadPicture(ip);
    }

    @GetMapping("/userCoverGetFile/{id}")
    public byte[] userCoverGetFile(@PathVariable("id") String id) {
        return userCoverGetFileService.userCoverGetFile(id);
    }

    @PostMapping("/userCoverFileUpload")
    public Result userCoverFileUpload(@RequestParam("file") MultipartFile[] files ,
                                     HttpServletRequest request){
        String ip = GetIp.getIpAddress(request);
        return userCoverFileUploadService.userCoverFileUpload(files,ip);
    }

}
