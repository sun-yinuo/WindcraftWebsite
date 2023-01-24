package com.sunyinuo.userconfig.service.impl;

import com.sunyinuo.userconfig.service.UpdateUserSignatureService;
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
public class UpdateUserSignatureServiceImpl implements UpdateUserSignatureService {

    private final RestTemplate restTemplate;

    public UpdateUserSignatureServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    /**
     * 更新用户简介
     * @param userSignature userSignature
     * @param ip            ip
     * @return return
     */
    @Override
    public Result updateUserSignature(String userSignature, String ip) {

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
            post.add("newUserSignature",userSignature);
            Integer updateUserDataBase = restTemplate.postForObject("http://user-signin/usersignin/api/service/updateUserDataBaseUserSignature",post,Integer.class);

            if (updateUserDataBase != null ){
                if (updateUserDataBase > 0){
                    return ResultUtil.result(ResultEnum.SUCCESS.getCode(), "修改成功");
                }else {
                    return ResultUtil.result(ResultEnum.SERVER_ERROR.getCode(),"emmm,我们的程序员写的代码似乎出了点问题呢🙃");
                }
            }else {
                return ResultUtil.result(ResultEnum.SERVER_ERROR.getCode(),"emmm,我们的程序员写的代码似乎出了点问题呢🙃");
            }

        }else {
            return ResultUtil.result(ResultEnum.SERVER_ERROR.getCode(), "没登陆你改简介干啥捏？🤔");
        }
    }
}
