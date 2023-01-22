package com.sunyinuo.userconfig.service.impl;

import com.sunyinuo.userconfig.service.UpdateUserNameService;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import result.Result;
import result.ResultEnum;
import result.ResultUtil;

import java.util.HashMap;

/**
 * @author sunyinuo
 */
@Service
public class UpdateUserNameServiceImpl implements UpdateUserNameService {

    private final RestTemplate restTemplate;

    public UpdateUserNameServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    /**
     * 更新用户名
     * @param newUserName 新用户名
     * @param ip          ip
     * @return 返回
     */
    @Override
    public Result updateUserName(String newUserName, String ip) {
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
            String loginUserName = (String) map.get("userName");

            MultiValueMap<String, Object> post = new LinkedMultiValueMap<>();
            post.add("userName", loginUserName);
            post.add("newUserName",newUserName);
            Integer updateUserDataBase = restTemplate.postForObject("http://user-signin/usersignin/api/service/updateUserDataBase",post,Integer.class);

            MultiValueMap<String, Object> post2 = new LinkedMultiValueMap<>();
            post2.add("key", ip);
            Boolean deleteLoginCacheByName = restTemplate.postForObject("http://user-signin/usersignin/api/service/deleteLoginCacheByName/",post2,Boolean.class);

            if (updateUserDataBase != null){
                if (updateUserDataBase >0){
                    if (Boolean.TRUE.equals(deleteLoginCacheByName)){
                        return ResultUtil.result(ResultEnum.SUCCESS.getCode(), "修改成功，请重新登陆");
                    }else {
                        return ResultUtil.result(ResultEnum.SERVER_ERROR.getCode(),"emmm,我们的程序员写的代码似乎出了点问题呢🙃");
                    }
                }else {
                    return ResultUtil.result(ResultEnum.SERVER_ERROR.getCode(),"emmm,我们的程序员写的代码似乎出了点问题呢🙃");
                }
            }

        }else {
            return ResultUtil.result(ResultEnum.SERVER_ERROR.getCode(), "没登陆你改用户名干啥捏？🤔");
        }
        return null;
    }
}
