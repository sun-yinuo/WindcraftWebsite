package com.sunyinuo.userconfig.service.impl;

import com.sunyinuo.userconfig.model.FileUpload;
import com.sunyinuo.userconfig.service.FileUploadService;
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
 * fileUpload
 * @author sunyinuo
 */
@Service
public class FileUploadServiceImpl implements FileUploadService {

    private final MongoTemplate mongoTemplate;
    public final RestTemplate restTemplate;

    public FileUploadServiceImpl(MongoTemplate mongoTemplate, RestTemplate restTemplate) {
        this.mongoTemplate = mongoTemplate;
        this.restTemplate = restTemplate;
    }


    @SneakyThrows
    @Override
    public Result fileUpload(MultipartFile[] files, String ip) {

        MultiValueMap<String, Object> postBody = new LinkedMultiValueMap<>();
        postBody.add("ip", ip);

        String userLoginCatchValue = restTemplate.postForObject("http://user-signin/usersignin/api/service/getUserLoginCatchValue/",postBody,String.class);

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
            mongoTemplate.remove(query, FileUpload.class);

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
