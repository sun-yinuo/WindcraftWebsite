package com.sunyinuo.reportgame.controller;

import com.alibaba.fastjson.JSONObject;
import com.sunyinuo.reportgame.model.FromReportMassage;
import com.sunyinuo.reportgame.service.impl.ReportServiceImpl;
import com.sunyinuo.reportgame.utils.ip.GetIp;
import org.springframework.web.bind.annotation.*;
import result.Result;

import javax.servlet.http.HttpServletRequest;

/**
 * @author sunyinuo
 */
@RestController
@RequestMapping("/reportgame/")
public class ReportController {

    //TODO (1)举报时，先上传图片后填写被举报人时出现bug ====> 「{获取被举报人->null}=>{填写被举报人->...}=>{后台获取图片->null}==>[前段获取图片list第一位->null;此时，ERROR产生]」
    //TODO (2)举报时，未上传图片时出现bug             ====> 「{后台获取图片->null}==>[前段获取图片list第一位->null;此时，ERROR产生]」

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
