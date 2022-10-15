package com.sunyinuo.windcraftbackendreport.service.api.impl;

import com.sunyinuo.windcraftbackendreport.model.FileUpload;
import com.sunyinuo.windcraftbackendreport.service.api.FileUploadService;
import com.sunyinuo.windcraftbackendreport.utils.ip.GetIp;
import lombok.SneakyThrows;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

/**
 * 文件上传服务层
 * @author sunyinuo
 */
@Service
public class FileUploadServiceImpl implements FileUploadService {
    private final MongoTemplate mongoTemplate;

    @Autowired
    public FileUploadServiceImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }


    /**
     * 文件上传
     * @param files 文件列表
     * @param httpServletRequest Request
     * @param reportedPlayer     reportedPlayer
     * @return 返回
     */
    @SneakyThrows
    @Override
    public FileUpload fileUpload(MultipartFile[] files,String reportedPlayer, HttpServletRequest httpServletRequest) {
        FileUpload fileUpload = new FileUpload();
        for (MultipartFile file : files) {

            //文件名
            fileUpload.setName(file.getOriginalFilename());
            //时间
            fileUpload.setCreatedTime(LocalDateTime.now());
            //内容
            fileUpload.setContent(new Binary(file.getBytes()));
            //类型
            fileUpload.setContentType(file.getContentType());
            //大小
            fileUpload.setSize(file.getSize());
            //ip
            fileUpload.setIp(GetIp.getIpAddress(httpServletRequest));
            //reportedPlayer
            fileUpload.setReportedPlayer(reportedPlayer);
        }

        //返回存入数据库的信息
        return mongoTemplate.save(fileUpload);
    }
}
