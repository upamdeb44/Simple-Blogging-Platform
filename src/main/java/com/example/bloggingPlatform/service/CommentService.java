package com.example.bloggingPlatform.service;

import com.example.bloggingPlatform.model.Comment;
import com.example.bloggingPlatform.model.Post;
import com.example.bloggingPlatform.repository.CommentRepository;
import com.example.bloggingPlatform.repository.PostRepository;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    public CommentService(CommentRepository commentRepository, PostRepository postRepository){
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;

    }

    public Comment addComment(Long postID, Comment comment){

        //1. find post by id
        Post post = postRepository.findById(postID)
                .orElseThrow(() -> new RuntimeException("Post Not Found"));

        //2. Link comment to post
        comment.setPost(post);

        //3.save comment
        return commentRepository.save(comment);
    }
}
