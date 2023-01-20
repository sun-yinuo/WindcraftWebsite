package com.sunyinuo.reportgame.controller;

import com.alibaba.fastjson.JSONObject;
import com.sunyinuo.reportgame.model.FromReportMassage;
import com.sunyinuo.reportgame.service.impl.ReportServiceImpl;
import com.sunyinuo.reportgame.utils.ip.GetIp;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import result.Result;

import javax.servlet.http.HttpServletRequest;

/**
 * @author sunyinuo
 */
@RestController
@RequestMapping("/reportgame/")
public class ReportController {
    public final ReportServiceImpl reportService;

    public ReportController(ReportServiceImpl reportService) {
        this.reportService = reportService;
    }


    @PostMapping("/report")
    public Result report(@RequestBody JSONObject jsonParam , HttpServletRequest httpServletRequest){


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
