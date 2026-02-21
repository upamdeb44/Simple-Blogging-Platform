package com.example.bloggingPlatform.controller;

import com.example.bloggingPlatform.model.Comment;
import com.example.bloggingPlatform.service.CommentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comments")
public class CommentController {
    private final CommentService commentService;
    public CommentController(CommentService commentService){
        this.commentService = commentService;
    }

    @PostMapping("/post/{postId}")
    public Comment createComment(@PathVariable Long postId, @RequestBody Comment comment){
        return commentService.addComment(postId,comment);
    }
}
