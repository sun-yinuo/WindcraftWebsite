package com.sunyinuo.userconfig.service.impl;

import com.sunyinuo.userconfig.model.FileUpload;
import com.sunyinuo.userconfig.service.UserHeadGetUserHeadPictureService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;

/**
 * @author sunyinuo
 */
@Service
@Slf4j
public class UserHeadGetUserHeadPictureServiceImpl implements UserHeadGetUserHeadPictureService {

    private final MongoTemplate mongoTemplate;
    private final RestTemplate restTemplate;

    public UserHeadGetUserHeadPictureServiceImpl(MongoTemplate mongoTemplate, RestTemplate restTemplate) {
        this.mongoTemplate = mongoTemplate;
        this.restTemplate = restTemplate;
    }


    /**
     * 获取用户头像
     * @param ip ip
     * @return 地址
     */
    @Override
    public String getUserHeadPicture(String ip) {
        MultiValueMap<String, Object> postBody = new LinkedMultiValueMap<>();
        postBody.add("ip", ip);
        String userLoginCatchValue = restTemplate.postForObject("http://user-signin/usersignin/api/service/getUserLoginCatchValue/",postBody,String.class);
        //去除双括号
        if (userLoginCatchValue != null) {
            @SuppressWarnings("AlibabaCollectionInitShouldAssignCapacity")
            HashMap<String,Object> map = new HashMap<>();
            userLoginCatchValue = userLoginCatchValue.replaceAll("[{}]","");
            //去除toString产生的空格
            userLoginCatchValue = userLoginCatchValue.replaceAll(" ","");
            //拆分两个key,value
            String[] allKeyValueList = userLoginCatchValue.split(",");
            for (String allKeyValue : allKeyValueList) {
                String[] keyValue = allKeyValue.split("=");
                map.put(keyValue[0],keyValue[1]);
            }

            Query query = Query.query(Criteria.where("userName").is(map.get("userName")));
            List<FileUpload> files = mongoTemplate.find(query, FileUpload.class);

            for (FileUpload file : files) {
                return "http://127.0.0.1:9000/userconfig/api/userHeadGetFile/"+file.getId();
            }
        }else {
            return "";
        }
        return null;
    }
}
