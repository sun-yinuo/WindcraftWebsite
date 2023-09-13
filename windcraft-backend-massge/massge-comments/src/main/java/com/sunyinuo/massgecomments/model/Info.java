package com.sunyinuo.massgecomments.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author sunyinuo
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Info {
    /**级**/
    private  Long layer;
    /**关联评论id**/
    private  Long reference;
    /**关联文章id**/
    private  Long referenceArticle;
}
