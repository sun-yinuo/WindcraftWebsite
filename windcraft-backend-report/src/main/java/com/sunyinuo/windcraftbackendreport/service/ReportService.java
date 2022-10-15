package com.sunyinuo.windcraftbackendreport.service;

import com.sunyinuo.windcraftbackendreport.model.FromReportMassage;

/**
 * 举报service接口
 * @author sunyinuo
 */
public interface ReportService {
    /**
     * report
     * @param ip ip
     * @param reportedPlayer 被举报玩家
     * @param fromReportMassage 表单信息
     * @return 是否成功
     */
    Integer report(String ip,String reportedPlayer, FromReportMassage fromReportMassage);
}
