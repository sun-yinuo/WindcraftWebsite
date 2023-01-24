package com.sunyinuo.userconfig.service.impl;

import com.sunyinuo.userconfig.service.GetLoginUserNameService;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

/**
 * @author sunyinuo
 */
@Service
public class GetLoginUserNameServiceImpl implements GetLoginUserNameService {

    private final RestTemplate restTemplate;

    public GetLoginUserNameServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * 获取登陆用户名
     *
     * @param ip ip
     * @return re
     */
    @Override
    public String getLoginUserName(String ip) {

        MultiValueMap<String, Object> postBody = new LinkedMultiValueMap<>();
        postBody.add("ip", ip);
        String userLoginCatchValue = restTemplate.postForObject("http://user-signin/usersignin/api/service/getUserLoginCatchValue/",postBody,String.class);

        if (userLoginCatchValue != null){
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

            return (String) map.get("userName");
        }else {
            return "";
        }
    }
}
