package com.sunyinuo.massgecomments.model;

import lombok.*;

/**
 * @author sunyinuo
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comments {
    /**序号**/
    private  Integer id;
    /**用户uuid**/
    private  String uuid;
    /**时间**/
    private  String time;
    /**具体内容**/
    private  String info;
    /**级**/
    private  Long layer;
    /**关联评论id**/
    private  Long reference;
    /**关联文章id**/
    private  Long referenceArticle;
}
