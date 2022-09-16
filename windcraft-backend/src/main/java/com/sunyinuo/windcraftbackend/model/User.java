package com.sunyinuo.windcraftbackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * User表实体类
 * @author sunyinuo
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    /**编号**/
    private int id;
    /**注册时间**/
    private long time;
    /**ip**/
    private String ip;
    /**用户名**/
    private String userName;
    /**密码**/
    private String userPassword;
}
