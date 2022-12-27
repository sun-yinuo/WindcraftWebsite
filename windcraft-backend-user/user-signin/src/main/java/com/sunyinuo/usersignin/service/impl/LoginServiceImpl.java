package com.sunyinuo.usersignin.service.impl;

import com.sunyinuo.usersignin.model.User;
import com.sunyinuo.usersignin.service.LoginService;
import com.sunyinuo.usersignin.service.db.impl.UserServiceImpl;
import com.sunyinuo.usersignin.utils.regex.SqlRegex;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;
import result.Result;
import result.ResultEnum;
import result.ResultUtil;

/**
 * 登陆业务逻辑层实现类
 * @author sunyinuo
 */
@Service
@CacheConfig(cacheNames = "loginStateCache")
public class LoginServiceImpl implements LoginService {

    private final UserServiceImpl userService;

    public LoginServiceImpl(UserServiceImpl userService) {
        this.userService = userService;
    }

    /**
     * 登陆
     * @param userName     用户名
     * @param userPassword 密码
     * @return code
     */
    @Override
    @CachePut(condition = "#result.code == 200",value = "loginStateCache", key = "#ip")
    public Result login(String userName, String userPassword, String ip) {
        User userList = userService.getUserByName(userName);

        //sql注入检查部分
        if (SqlRegex.sqlRegex(userName) || SqlRegex.sqlRegex(userPassword)){
            return ResultUtil.result(ResultEnum.SERVER_ERROR.getCode(),"你是tm真行,给我tm玩这出,你以为我没防啊?");
        }

        if (userList != null){
            //登陆成功
            if (userName.equals(userList.getUserName()) && userPassword.equals(userList.getUserPassword())) {
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
