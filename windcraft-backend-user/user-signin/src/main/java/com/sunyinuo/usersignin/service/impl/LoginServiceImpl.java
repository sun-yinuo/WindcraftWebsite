package com.sunyinuo.usersignin.service.impl;

import com.sunyinuo.usersignin.model.User;
import com.sunyinuo.usersignin.service.LoginService;
import com.sunyinuo.usersignin.service.db.impl.UserServiceImpl;
import com.sunyinuo.usersignin.utils.regex.SqlRegex;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import result.Result;
import result.ResultEnum;
import result.ResultUtil;

import java.util.HashMap;

/**
 * 登陆业务逻辑层实现类
 * @author sunyinuo
 */
@Service
public class LoginServiceImpl implements LoginService {
    private final   HashMap<String,Object> userInfo = new HashMap<>();
    private final   RedisTemplate<Object,Object> redisTemplate;
    private final   UserServiceImpl userService;

    public LoginServiceImpl(UserServiceImpl userService, RedisTemplate<Object, Object> redisTemplate) {
        this.userService = userService;
        this.redisTemplate = redisTemplate;
    }

    /**
     * 登陆
     * @param userName     用户名
     * @param userPassword 密码
     * @return code
     */
    @Override
    public Result login(String userName, String userPassword, String ip) {
        User userList = userService.getUserByName(userName);

        //sql注入检查部分
        if (SqlRegex.sqlRegex(userName) || SqlRegex.sqlRegex(userPassword)){
            return ResultUtil.result(ResultEnum.SERVER_ERROR.getCode(),"你是tm真行,给我tm玩这出,你以为我没防啊?");
        }

        if (userList != null){
            //登陆成功
            if (userName.equals(userList.getUserName()) && userPassword.equals(userList.getUserPassword())) {
                userInfo.put("userName",userList.getUserName());
                userInfo.put("userId",userList.getId());
                redisTemplate.opsForValue().set(userList.getIp(),userInfo.toString());
                return ResultUtil.result(ResultEnum.SUCCESS.getCode(),"登录成功");
            }
            if (!userPassword.equals(userList.getUserPassword())){
                return ResultUtil.result(ResultEnum.SERVER_ERROR.getCode(),"用户名或密码错误");
            }
            if (!userName.equals(userList.getUserName())){
                return ResultUtil.result(ResultEnum.SERVER_ERROR.getCode(),"用户名或密码错误");
            }
        }
        if (userList == null){
            return ResultUtil.result(ResultEnum.SERVER_ERROR.getCode(),"用户名或密码错误");
        }
        return null;
    }
}
