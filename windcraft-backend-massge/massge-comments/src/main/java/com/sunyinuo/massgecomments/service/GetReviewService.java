package com.sunyinuo.massgecomments.service;

import com.sunyinuo.massgecomments.model.Comments;
import com.sunyinuo.massgecomments.model.Info;

import java.util.List;

/**
 * @author sunyinuo
 */
public interface GetReviewService {

    /**
     * 查询
     * @param info 查询条件
     * @return 评论内容
     */
    List<Comments> getReview(Info info);

}
