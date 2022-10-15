package com.sunyinuo.windcraftbackendreport.controller;

import com.alibaba.fastjson.JSONObject;
import com.sunyinuo.windcraftbackendreport.model.FromReportMassage;
import com.sunyinuo.windcraftbackendreport.service.impl.ReportServiceImpl;
import com.sunyinuo.windcraftbackendreport.utils.ip.GetIp;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author sunyinuo
 */
@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
public class ReportController {
    public final ReportServiceImpl reportService;

    public ReportController(ReportServiceImpl reportService) {
        this.reportService = reportService;
    }


    @PostMapping("/report")
    public Integer report(@RequestBody JSONObject jsonParam , HttpServletRequest httpServletRequest){


        FromReportMassage fromReportMassage = new FromReportMassage();
        String ip = GetIp.getIpAddress(httpServletRequest);
        String reportedPlayer = jsonParam.getString("reportedPlayer");

        fromReportMassage.setReportedPlayer(reportedPlayer);
        fromReportMassage.setReportPlayer(jsonParam.getString("reportPlayer"));
        fromReportMassage.setQqCode(jsonParam.getString("qqCode"));
        fromReportMassage.setFunction(jsonParam.getString("function"));
        fromReportMassage.setPlace(jsonParam.getString("place"));
        fromReportMassage.setDate(jsonParam.getString("date"));
        fromReportMassage.setIp(ip);

        return reportService.report(ip,reportedPlayer,fromReportMassage);
    }

}
