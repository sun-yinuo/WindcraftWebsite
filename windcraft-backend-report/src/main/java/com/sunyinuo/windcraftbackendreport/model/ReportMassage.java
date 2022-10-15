package com.sunyinuo.windcraftbackendreport.model;

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
    private FileUpload fileUpload;
    private List<String> pictureUrl;

}
