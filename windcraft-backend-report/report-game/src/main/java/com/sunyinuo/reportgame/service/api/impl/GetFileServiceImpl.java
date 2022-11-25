package com.sunyinuo.reportgame.service.api.impl;

import com.sunyinuo.reportgame.model.FileUpload;
import com.sunyinuo.reportgame.service.api.GetFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

/**
 * @author sunyinuo
 */
@Service
public class GetFileServiceImpl implements GetFileService {

    private final MongoTemplate mongoTemplate;

    @Autowired
    public GetFileServiceImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }


    /**
     * 根据id获取图片
     * @param id id
     * @return 图片
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
