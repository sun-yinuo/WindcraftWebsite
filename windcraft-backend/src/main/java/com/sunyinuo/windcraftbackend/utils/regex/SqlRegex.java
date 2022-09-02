package com.sunyinuo.windcraftbackend.utils.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

/**
 * sql注入校验
 * @author sunyinuo
 */
public class SqlRegex {
    /**正则表达式**/
    private final static String PATTERN = "(?:')|(?:--)|(/\\*(?:.|[\\n\\r])*?\\*/)|" + "(\\b(select|update|union|and|or|delete|insert|trancate|char|into|substr|ascii|declare|exec|count|master|drop|execute)\\b)";
    /**模式**/
    private final static Pattern SQL_PATTERN = Pattern.compile(PATTERN, Pattern.CASE_INSENSITIVE);

    /**
     * 防sql注入(字符拦截)
     * @param input 输入的内容
     * @return 是否需要拦截 if == true 进行拦截 if !== true 不拦截
     */
    public static boolean sqlRegex(String input) {
        return SQL_PATTERN.matcher(input).find();
    }
}
