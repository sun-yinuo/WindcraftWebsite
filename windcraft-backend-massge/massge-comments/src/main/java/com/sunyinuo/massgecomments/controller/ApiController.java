package com.sunyinuo.massgecomments.controller;

import com.sunyinuo.massgecomments.model.Comments;
import com.sunyinuo.massgecomments.model.Info;
import com.sunyinuo.massgecomments.service.db.impl.CommentsServiceImpl;
import com.sunyinuo.massgecomments.service.impl.GetReviewServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author sunyinuo
 */
@RestController
@RequestMapping("/massgecomments/api")
@Slf4j
public class ApiController {

    public final CommentsServiceImpl commentsService;
    public final GetReviewServiceImpl getReviewService;

    public ApiController(CommentsServiceImpl commentsService, GetReviewServiceImpl getReviewService) {
        this.commentsService = commentsService;
        this.getReviewService = getReviewService;
    }

    @PostMapping("/addReview")
    public int addReview(@RequestBody Comments comments){
        return commentsService.addComments(comments);
    }

    @PostMapping("/getReview")
    public List<Comments> getReview(@RequestBody Info info){
        return getReviewService.getReview(info);
    }

}
