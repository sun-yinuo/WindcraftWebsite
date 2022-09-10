package com.sunyinuo.windcraftbackend.utils.regex;

import java.util.regex.Pattern;

/**
 * 密码正则:规则至少8个字符，至少1个大写字母，1个小写字母和1个数字
 * @author sunyinuo
 */
public class PasswordRegex {
    private static final String PATTERN = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{6,}$";

    /**
     * 判断是否合规
     * @param input 输入内容
     * @return 是否需要拦截 if == true 进行拦截 if !== true 不拦截
     */
    public static boolean passwordRegex(String input){
        return !Pattern.matches(PATTERN, input);
    }
}
