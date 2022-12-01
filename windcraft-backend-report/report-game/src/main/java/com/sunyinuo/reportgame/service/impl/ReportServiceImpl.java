package com.sunyinuo.reportgame.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.sunyinuo.reportgame.config.RabbitmqConfig;
import com.sunyinuo.reportgame.model.FileUpload;
import com.sunyinuo.reportgame.model.FromReportMassage;
import com.sunyinuo.reportgame.model.ReportMassage;
import com.sunyinuo.reportgame.service.ReportService;
import com.sunyinuo.reportgame.utils.response.ReportResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 举报service实现类
 * @author sunyinuo
 */
@Service
@Slf4j
public class ReportServiceImpl implements ReportService {

    private final RabbitTemplate rabbitTemplate;
    private final MongoTemplate mongoTemplate;
    private static final String NULL = "";

    @Autowired
    public ReportServiceImpl(RabbitTemplate rabbitTemplate, MongoTemplate mongoTemplate) {
        this.rabbitTemplate = rabbitTemplate;
        this.mongoTemplate = mongoTemplate;
    }

    /**
     * report
     * @param ip                ip
     * @param reportedPlayer    被举报玩家
     * @param fromReportMassage 表单信息
     * @return 是否成功
     */
    @Override
    public Integer report(String ip, String reportedPlayer, FromReportMassage fromReportMassage) {

        //因为框架所限null为""
        if (fromReportMassage.getReportPlayer().equals(NULL)
                || fromReportMassage.getReportedPlayer() .equals(NULL)
                || fromReportMassage.getQqCode() .equals(NULL)
                || fromReportMassage.getFunction() .equals(NULL)
                || fromReportMassage.getPlace() .equals(NULL)){

            return ReportResponse.CODE_400;
        }

        try {
            //获取图片信息
            Query query = Query.query(Criteria.where("ip").is(ip).and("reportedPlayer").is(reportedPlayer));
            List<FileUpload> files = mongoTemplate.find(query, FileUpload.class);

            ReportMassage reportMassage = new ReportMassage();
            List<String> url = new ArrayList<>();


            for (FileUpload file : files) {
                reportMassage.setFileUpload(file);
                url.add("http://127.0.0.1:9000/reportgame/api/getFile/" + file.getId());
                reportMassage.setPictureUrl(url);
            }
            reportMassage.setFromReportMassage(fromReportMassage);

            log.info("massage:{}", reportMassage);

            rabbitTemplate.convertAndSend(RabbitmqConfig.EXCHANGE_TOPICS_INFORM,"inform.report", JSONObject.toJSONString(reportMassage));
        }catch (Exception e){
            log.error("reportError:",e);
            return ReportResponse.CODE_500;
        }

        return ReportResponse.CODE_200;
    }
}
