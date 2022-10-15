package com.sunyinuo.windcraftbackendreport.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.Binary;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

/**
 * 文件实体类
 * @author sunyinuo
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FileUpload {

    @Id
    private String id;
    /** 文件名 */
    private String name;
    /** 上传时间 */
    private LocalDateTime createdTime;
    /** 文件内容 */
    private Binary content;
    /** 文件类型 */
    private String contentType;
    /** 文件大小 */
    private long size;
    /**ip:用于表单与图片配套**/
    private String ip;
    /**被举报玩家:用于表单与图片配套**/
    private String reportedPlayer;
}
