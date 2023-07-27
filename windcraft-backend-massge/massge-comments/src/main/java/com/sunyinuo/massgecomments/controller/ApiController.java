package com.sunyinuo.massgecomments.controller;

import com.sunyinuo.massgecomments.model.Comments;
import com.sunyinuo.massgecomments.service.db.impl.CommentsServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sunyinuo
 */
@RestController
@RequestMapping("/massgecomments/api")
@Slf4j
public class ApiController {

    public final CommentsServiceImpl commentsService;

    public ApiController(CommentsServiceImpl commentsService) {
        this.commentsService = commentsService;
    }

    @PostMapping("/addReview")
    public int addReview(@RequestBody Comments comments){
        return commentsService.addComments(comments);
    }



}
