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
    private int id;
    private long time;
    private String ip;
    private String userName;
    private String userPassword;
}
