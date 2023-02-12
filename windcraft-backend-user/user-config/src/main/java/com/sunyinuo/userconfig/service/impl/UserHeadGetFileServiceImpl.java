package com.sunyinuo.userconfig.service.impl;

import com.sunyinuo.userconfig.model.FileUpload;
import com.sunyinuo.userconfig.service.UserHeadGetFileService;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

/**
 * @author sunyinuo
 */
@Service
public class UserHeadGetFileServiceImpl implements UserHeadGetFileService {

    private final MongoTemplate mongoTemplate;

    public UserHeadGetFileServiceImpl(MongoTemplate mongoTemplate) {
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
