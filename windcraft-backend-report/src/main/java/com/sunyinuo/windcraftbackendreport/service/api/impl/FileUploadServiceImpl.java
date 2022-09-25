package com.sunyinuo.windcraftbackendreport.service.api.impl;

import com.sunyinuo.windcraftbackendreport.model.FileUpload;
import com.sunyinuo.windcraftbackendreport.service.api.FileUploadService;
import com.sunyinuo.windcraftbackendreport.utils.response.FileUploadResponse;
import lombok.SneakyThrows;
import org.bson.types.Binary;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

/**
 * 文件上传服务层
 * @author sunyinuo
 */
@Service
public class FileUploadServiceImpl implements FileUploadService {

    private final MongoTemplate mongoTemplate;

    public FileUploadServiceImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }


    /**
     * 文件上传
     * @param files 文件列表
     * @return 返回
     */
    @SneakyThrows
    @Override
    public Integer fileUpload(MultipartFile[] files) {

        for (MultipartFile file : files) {

            //如果文件为空
            if (file.isEmpty()){
                return FileUploadResponse.CODE_400;
            }

            try {
                // 文件名
                String fileName = file.getOriginalFilename();

                FileUpload fileUpload = new FileUpload();
                //文件名
                fileUpload.setName(fileName);
                //时间
                fileUpload.setCreatedTime(LocalDateTime.now());
                //内容
                fileUpload.setContent(new Binary(file.getBytes()));
                //类型
                fileUpload.setContentType(file.getContentType());
                //大小
                fileUpload.setSize(file.getSize());

                FileUpload savedFile = mongoTemplate.save(fileUpload);
            }catch (Exception ex){
                return FileUploadResponse.CODE_500;
            }

            return FileUploadResponse.CODE_200;
        }

        return null;
    }
}
