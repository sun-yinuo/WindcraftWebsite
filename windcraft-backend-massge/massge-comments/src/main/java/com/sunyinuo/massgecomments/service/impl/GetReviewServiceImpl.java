package com.sunyinuo.massgecomments.service.impl;

import com.sunyinuo.massgecomments.model.Comments;
import com.sunyinuo.massgecomments.model.Info;
import com.sunyinuo.massgecomments.service.GetReviewService;
import com.sunyinuo.massgecomments.service.db.impl.CommentsServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunyinuo
 */
@Service
@Slf4j
public class GetReviewServiceImpl implements GetReviewService {

    public final CommentsServiceImpl commentsService;

    public GetReviewServiceImpl(CommentsServiceImpl commentsService) {
        this.commentsService = commentsService;
    }


    /**
     * 查询
     * @param info 查询条件
     * @return 评论内容
     */
    @Override
    public List<Comments> getReview(Info info) {
       Long reference = info.getReference();
       Long layer = info.getLayer();
       Long referenceArticle = info.getReferenceArticle();

       //根据文章id查询
       List<Comments> commentsByReferenceArticle = commentsService.getCommentsByReferenceArticle(referenceArticle);
       //根据评论层级筛选后列表
       List<Comments> commentsByLayer = new ArrayList<>();

        if (reference == null && layer != null){
            for (Comments comments : commentsByReferenceArticle) {
                if (comments.getLayer().equals(layer)){
                    commentsByLayer.add(comments);
                }
            }
            return commentsByLayer;
        }

        if (reference != null && layer == null){

            return commentsService.getCommentsByReference(reference);
        }

        return null;
    }
}
