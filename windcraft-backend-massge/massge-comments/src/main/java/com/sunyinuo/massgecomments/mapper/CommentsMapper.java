package com.sunyinuo.massgecomments.mapper;

import com.sunyinuo.massgecomments.model.Comments;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author sunyinuo
 */
@Mapper
public interface CommentsMapper {

    /**
     * 获取所有评论
     * @return model list
     */
    List<Comments> getCommentsList();

    /**
     * 根据id获取评论
     * @param id id
     * @return model
     */
    Comments getCommentsById(int id);

    /**
     * 根据uuid查询评论
     * @param uuid uuid
     * @return model list
     */
    List<Comments> getCommentsByUuid(String uuid);


    /**
     * 根据时间获取评论
     * @param time time
     * @return model list
     */
    List<Comments> getCommentsByTime(String time);

    /**
     * 根据评论内容查询评论
     * @param info info
     * @return model list
     */
    List<Comments> getCommentsByInfo(String info);

    /**
     * 根据评论层数获取评论
     * @param layer 层
     * @return model list
     */
    List<Comments> getCommentsByLayer(long layer);

    /**
     * 根据关联评论id获取评论
     * @param reference 关联评论id
     * @return model list
     */
    List<Comments> getCommentsByReference(long reference);

    /**
     * 根据关联文章id获取评论
     * @param referenceArticle 关联文章id
     * @return model list
     */
    List<Comments> getCommentsByReferenceArticle(long referenceArticle);

    /**
     * 添加评论
     * @param comments model
     * @return 影响
     */
    int addComments(Comments comments);

    /**
     * 根据uuid删除评论
     * @param uuid uuid
     * @return 影响
     */
    int deleteCommentsByUuid(String uuid);


    /**
     * 根据id删除评论
     * @param id id
     * @return 影响
     */
    int deleteCommentsById(int id);
}
