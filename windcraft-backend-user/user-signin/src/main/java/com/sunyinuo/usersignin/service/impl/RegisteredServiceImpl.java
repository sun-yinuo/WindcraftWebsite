package com.sunyinuo.usersignin.service.impl;

import com.sunyinuo.usersignin.model.User;
import com.sunyinuo.usersignin.service.RegisteredService;
import com.sunyinuo.usersignin.service.db.impl.UserServiceImpl;
import com.sunyinuo.usersignin.utils.regex.PasswordRegex;
import com.sunyinuo.usersignin.utils.regex.SqlRegex;
import org.springframework.stereotype.Service;
import result.Result;
import result.ResultEnum;
import result.ResultUtil;

import java.util.List;


/**
 * 登陆业务逻辑层实现类
 * @author sunyinuo
 */
@Service
public class RegisteredServiceImpl implements RegisteredService {

    private final UserServiceImpl userService;

    public RegisteredServiceImpl(UserServiceImpl userService) {
        this.userService = userService;
    }

    /**
     * 注册
     * @param userName     用户名
     * @param userPassword 密码
     * @param ip HttpServletRequest
     * @return code
     */
    @Override
    public Result registered(String userName, String userPassword, String ip) {
        User userListByName = userService.getUserByName(userName);
        List<User> userListByIp = userService.getUserByIp(ip);

        //sql注入检查部分
        if (SqlRegex.sqlRegex(userName) || SqlRegex.sqlRegex(userPassword)){
            return ResultUtil.result(ResultEnum.SERVER_ERROR.getCode(), "你是tm真行,给我tm玩这出,你以为我没防啊?");
        }

        //用户名或密码不合规
        if (PasswordRegex.passwordRegex(userPassword)){
            return ResultUtil.result(ResultEnum.SERVER_ERROR.getCode(), "用户名或密码不符合规范");
        }

        if (userListByIp != null){
            return ResultUtil.result(ResultEnum.SERVER_ERROR.getCode(),"别想开小号🤬");
        }

        //用户名重复
        if (userListByName == null){
            if (!PasswordRegex.passwordRegex(userPassword)){
                User user = new User();

                //单位ms
                user.setTime(System.currentTimeMillis());
                user.setUserName(userName);
                user.setUserPassword(userPassword);
                user.setIp(ip);

                if (userService.addUser(user) == 1){
                    return ResultUtil.result(ResultEnum.SUCCESS.getCode(), "注册成功");
                }
                if (userService.addUser(user) == 0){
                    return ResultUtil.result(ResultEnum.SERVER_ERROR.getCode(), "注册失败,服务器异常");
                }
            }
        }

        if (userListByName != null){
            return ResultUtil.result(ResultEnum.SERVER_ERROR.getCode(), "用户名重复");
        }

        return null;
    }
}
