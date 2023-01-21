package com.sunyinuo.userconfig.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.Binary;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

/**
 * @author sunyinuo
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
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
    /**userName**/
    private String userName;


}
