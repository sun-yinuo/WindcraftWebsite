package com.sunyinuo.windcraftbackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ban实体类
 * @author sunyinuo
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ban {
    /**id**/
    private int id;
    /**来源**/
    private String source;
    /**原因**/
    private String reason;
    /**封禁时间**/
    private String banTime;
    /**解封时间**/
    private String unBanTime;
    /**封禁类型**/
    private String banType;
    /**玩家名称**/
    private String name;
}
