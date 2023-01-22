package com.sunyinuo.userconfig.service.impl;

import com.sunyinuo.userconfig.service.UserLogOutService;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class UserLogOutServiceImpl implements UserLogOutService {

    private final RestTemplate restTemplate;

    public UserLogOutServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * 用户注销
     * @param confirmUser 确认用户名
     * @param ip          ip
     * @return 返回
     */
    @Override
    public Result userLogOut(String confirmUser, String ip) {

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
            //判断输入的确认用户和实际登陆的一致则执行del操作
            if (confirmUser.equals(loginUserName)){
                MultiValueMap<String, Object> post = new LinkedMultiValueMap<>();
                post.add("name", loginUserName);
                Integer deleteUserByName = restTemplate.postForObject("http://user-signin/usersignin/api/service/deleteUserByName",post,Integer.class);

                MultiValueMap<String, Object> post2 = new LinkedMultiValueMap<>();
                post2.add("key", ip);
                Boolean deleteLoginCacheByName = restTemplate.postForObject("http://user-signin/usersignin/api/service/deleteLoginCacheByName/",post2,Boolean.class);
                if (deleteUserByName != null){
                    if (deleteUserByName > 0){
                        if (Boolean.TRUE.equals(deleteLoginCacheByName)){
                            return ResultUtil.result(ResultEnum.SUCCESS.getCode(), "注销成功,有缘再见🙋‍");
                        }else {
                            return ResultUtil.result(ResultEnum.SERVER_ERROR.getCode(),"emmm,我们的程序员写的代码似乎出了点问题呢🙃");
                        }
                    }else {
                        return ResultUtil.result(ResultEnum.SERVER_ERROR.getCode(),"emmm,我们的程序员写的代码似乎出了点问题呢🙃");
                    }
                }

            }else {
                return ResultUtil.result(ResultEnum.SERVER_ERROR.getCode(), "确认用户名竟然和你登陆的账号不一样,真奇怪🤔");
            }

        }else {
            return ResultUtil.result(ResultEnum.SERVER_ERROR.getCode(), "没登陆你注销干嘛捏？🤔");
        }

        return null;
    }
}
