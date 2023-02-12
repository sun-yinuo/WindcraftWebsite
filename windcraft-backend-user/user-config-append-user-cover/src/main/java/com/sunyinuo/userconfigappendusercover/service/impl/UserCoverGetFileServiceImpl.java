package com.sunyinuo.userconfigappendusercover.service.impl;

import com.sunyinuo.userconfigappendusercover.model.FileUpload;
import com.sunyinuo.userconfigappendusercover.service.UserCoverGetFileService;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

/**
 * @author sunyinuo
 */
@Service
public class UserCoverGetFileServiceImpl implements UserCoverGetFileService {

    private final MongoTemplate mongoTemplate;
    public UserCoverGetFileServiceImpl( MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }


    /**
     * 根据id获取图片
     *
     * @param id id
     * @return 图片Byte
     */
    @Override
    public byte[] userCoverGetFile(String id) {
        byte[] data = null;
        FileUpload file = mongoTemplate.findById(id,FileUpload.class);
        if (file != null) {
            data = file.getContent().getData();
        }
        return data;
    }
}
