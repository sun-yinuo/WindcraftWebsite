package com.sunyinuo.windcraftbackend.utils.response;

/**
 * 注册响应
 * @author sunyinuo
 */
public class RegisteredResponse {
    /**注册请求成功时返回**/
    public static final String CODE_700 = "700";
    /**注册时进行sql注入**/
    public static final String CODE_710 = "710";
    /**注册时用户名或密码不符合规范**/
    public static final String CODE_770 = "770";
    /**注册失败**/
    public static final String CODE_500 = "500";
}
