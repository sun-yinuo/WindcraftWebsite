package com.sunyinuo.userconfig.service.impl;

import com.sunyinuo.userconfig.model.FileUpload;
import com.sunyinuo.userconfig.service.GetFileService;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

/**
 * @author sunyinuo
 */
@Service
public class GetFileServiceImpl implements GetFileService {

    private final MongoTemplate mongoTemplate;

    public GetFileServiceImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    /**
     * 根据id获取图片
     * @param id id
     * @return 图片Byte
     */
    @Override
    public byte[] getFile(String id) {
        byte[] data = null;
        FileUpload file = mongoTemplate.findById(id, FileUpload.class);
        if (file != null) {
            data = file.getContent().getData();
        }
        return data;
    }
}
