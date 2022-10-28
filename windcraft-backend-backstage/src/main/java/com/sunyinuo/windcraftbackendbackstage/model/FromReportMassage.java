package com.sunyinuo.windcraftbackendbackstage.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 举报信息实体类
 * @author sunyinuo
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FromReportMassage {

    private String reportedPlayer;
    private String reportPlayer;
    private String qqCode;
    private String function;
    private String place;
    private String date;
    private String ip;


}
