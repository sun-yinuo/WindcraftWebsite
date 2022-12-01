package com.sunyinuo.bancrud.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * warning表实体类
 * @author sunyinuo
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Warning {

    /**编号**/
    private int id;
    /**来源**/
    private String source;
    /**原因**/
    private String reason;
    /**时间**/
    private long time;
    /**玩家名称**/
    private String name;

}
