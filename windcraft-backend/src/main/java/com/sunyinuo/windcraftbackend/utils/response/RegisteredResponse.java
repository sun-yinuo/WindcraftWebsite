package com.sunyinuo.windcraftbackend.utils.response;

/**
 * 注册响应
 * @author sunyinuo
 */
public class RegisteredResponse {
    /**注册请求成功时返回**/
    public static final Integer CODE_700 = 700;
    /**注册时进行sql注入**/
    public static final Integer CODE_710 = 710;
    /**注册时用户名或密码不符合规范**/
    public static final Integer CODE_770 = 770;
    /**注册时用户名重复**/
    public static final Integer CODE_750 = 750;
    /**一个ip注册多次**/
    public static final Integer CODE_730 = 730;
    /**注册失败**/
    public static final Integer CODE_500 = 500;
}
