package com.sunyinuo.massgecomments.service.db.impl;

import com.sunyinuo.massgecomments.mapper.CommentsMapper;
import com.sunyinuo.massgecomments.model.Comments;
import com.sunyinuo.massgecomments.service.db.CommentsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author sunyinuo
 */
@Service
public class CommentsServiceImpl implements CommentsService {

    @Resource
    public CommentsMapper commentsMapper;


    /**
     * 获取所有评论
     *
     * @return model list
     */
    @Override
    public List<Comments> getCommentsList() {
        return commentsMapper.getCommentsList();
    }

    /**
     * 根据id获取评论
     *
     * @param id id
     * @return model
     */
    @Override
    public Comments getCommentsById(int id) {
        return commentsMapper.getCommentsById(id);
    }

    /**
     * 根据uuid查询评论
     *
     * @param uuid uuid
     * @return model list
     */
    @Override
    public List<Comments> getCommentsByUuid(String uuid) {
        return commentsMapper.getCommentsByUuid(uuid);
    }

    /**
     * 根据时间获取评论
     *
     * @param time time
     * @return model list
     */
    @Override
    public List<Comments> getCommentsByTime(String time) {
        return commentsMapper.getCommentsByTime(time);
    }

    /**
     * 根据评论内容查询评论
     *
     * @param info info
     * @return model list
     */
    @Override
    public List<Comments> getCommentsByInfo(String info) {
        return commentsMapper.getCommentsByInfo(info);
    }

    /**
     * 根据评论层数获取评论
     *
     * @param layer 层
     * @return model list
     */
    @Override
    public List<Comments> getCommentsByLayer(long layer) {
        return commentsMapper.getCommentsByLayer(layer);
    }

    /**
     * 根据关联评论id获取评论
     *
     * @param reference 关联评论id
     * @return model list
     */
    @Override
    public List<Comments> getCommentsByReference(long reference) {
        return commentsMapper.getCommentsByReference(reference);
    }

    /**
     * 根据关联文章id获取评论
     *
     * @param referenceArticle 关联文章id
     * @return model list
     */
    @Override
    public List<Comments> getCommentsByReferenceArticle(long referenceArticle) {
        return commentsMapper.getCommentsByReferenceArticle(referenceArticle);
    }

    /**
     * 添加评论
     *
     * @param comments model
     * @return 影响
     */
    @Override
    public int addComments(Comments comments) {
        return commentsMapper.addComments(comments);
    }

    /**
     * 根据uuid删除评论
     *
     * @param uuid uuid
     * @return 影响
     */
    @Override
    public int deleteCommentsByUuid(String uuid) {
        return commentsMapper.deleteCommentsByUuid(uuid);
    }

    /**
     * 根据id删除评论
     *
     * @param id id
     * @return 影响
     */
    @Override
    public int deleteCommentsById(int id) {
        return commentsMapper.deleteCommentsById(id);
    }
}
