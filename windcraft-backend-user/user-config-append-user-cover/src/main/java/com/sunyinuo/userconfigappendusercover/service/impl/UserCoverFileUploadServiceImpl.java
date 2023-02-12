package com.sunyinuo.userconfigappendusercover.service.impl;

import com.sunyinuo.userconfigappendusercover.model.FileUpload;
import com.sunyinuo.userconfigappendusercover.service.UserCoverFileUploadService;
import lombok.SneakyThrows;
import org.bson.types.Binary;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import result.Result;
import result.ResultEnum;
import result.ResultUtil;

import java.time.LocalDateTime;
import java.util.HashMap;

/**
 * @author sunyinuo
 */
@Service
public class UserCoverFileUploadServiceImpl implements UserCoverFileUploadService {


    public final RestTemplate restTemplate;
    public final MongoTemplate mongoTemplate;

    public UserCoverFileUploadServiceImpl(RestTemplate restTemplate, MongoTemplate mongoTemplate) {
        this.restTemplate = restTemplate;
        this.mongoTemplate = mongoTemplate;
    }

    /**
     * 图片上传
     *
     * @param files files
     * @param ip    ip
     * @return return
     */
    @SneakyThrows
    @Override
    public Result userCoverFileUpload(MultipartFile[] files, String ip) {
        MultiValueMap<String, Object> userLoginCatchValueBody = new LinkedMultiValueMap<>();
        userLoginCatchValueBody.add("ip", ip);

        String userLoginCatchValue = restTemplate.postForObject("http://user-signin/usersignin/api/service/getUserLoginCatchValue/",userLoginCatchValueBody,String.class);

        if(userLoginCatchValue == null){
            return ResultUtil.result(ResultEnum.SERVER_ERROR.getCode(),"请先登陆");
        }

        FileUpload fileUpload = new FileUpload();
        for (MultipartFile file : files) {

            @SuppressWarnings("AlibabaCollectionInitShouldAssignCapacity")
            HashMap<String, Object> map = new HashMap<>();
            //去除双括号
            userLoginCatchValue = userLoginCatchValue.replaceAll("[{}]", "");
            //去除toString产生的空格
            userLoginCatchValue = userLoginCatchValue.replaceAll(" ", "");
            //拆分两个key,value
            String[] allKeyValueList = userLoginCatchValue.split(",");
            for (String allKeyValue : allKeyValueList) {
                String[] keyValue = allKeyValue.split("=");
                map.put(keyValue[0], keyValue[1]);
            }

            Query query = Query.query(Criteria.where("userName").is(map.get("userName")));

            mongoTemplate.remove(query,FileUpload.class);

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
            //userName
            fileUpload.setUserName((String) map.get("userName"));

        }

        mongoTemplate.save(fileUpload);
        return ResultUtil.result(ResultEnum.SUCCESS.getCode(),"上传成功");
    }
}
