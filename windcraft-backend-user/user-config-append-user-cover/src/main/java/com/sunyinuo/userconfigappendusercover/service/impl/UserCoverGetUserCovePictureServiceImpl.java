package com.sunyinuo.userconfigappendusercover.service.impl;


import com.sunyinuo.userconfigappendusercover.model.FileUpload;
import com.sunyinuo.userconfigappendusercover.service.UserCoverGetUserCovePictureService;
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
public class UserCoverGetUserCovePictureServiceImpl implements UserCoverGetUserCovePictureService {

    private final RestTemplate restTemplate;
    private final MongoTemplate mongoTemplate;

    public UserCoverGetUserCovePictureServiceImpl(MongoTemplate mongoTemplate, RestTemplate restTemplate) {
        this.mongoTemplate = mongoTemplate;
        this.restTemplate = restTemplate;
    }

    /**
     * 根据ip获取用户封面
     *
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

            List<FileUpload> list = mongoTemplate.find(query, FileUpload.class);
            for (FileUpload fileUpload : list) {
                return "http://127.0.0.1:9000/userconfigappendusercover/api/userCoverGetFile/"+fileUpload.getId();
            }
        }else {
            return "";
        }
        return "";
    }
}
