package com.sunyinuo.bancrud.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * prohibit实体类
 * @author sunyinuo
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Prohibit {
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
    /**玩家name**/
    private String name;

}
