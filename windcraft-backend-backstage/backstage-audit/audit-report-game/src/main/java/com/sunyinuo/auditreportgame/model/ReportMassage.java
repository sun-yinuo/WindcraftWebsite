package com.sunyinuo.auditreportgame.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author sunyinuo
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReportMassage {

    private FromReportMassage fromReportMassage;
    private List<String> pictureUrl;

}
