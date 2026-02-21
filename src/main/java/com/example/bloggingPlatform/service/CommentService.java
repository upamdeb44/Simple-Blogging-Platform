package com.example.bloggingPlatform.service;

import com.example.bloggingPlatform.model.Comment;
import com.example.bloggingPlatform.model.Post;
import com.example.bloggingPlatform.model.User;
import com.example.bloggingPlatform.repository.CommentRepository;
import com.example.bloggingPlatform.repository.PostRepository;
import com.example.bloggingPlatform.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final EmailService emailService;
    private final UserRepository userRepository;

    public CommentService(CommentRepository c, PostRepository p, EmailService e, UserRepository u){
        this.commentRepository = c;
        this.postRepository = p;
        this.emailService = e;
        this.userRepository = u;

    }

    public Comment addComment(Long postID, Comment comment){

        //1. find post by id
        Post post = postRepository.findById(postID)
                .orElseThrow(() -> new RuntimeException("Post Not Found"));

        //2. Link comment to post
        comment.setPost(post);

        //3.save comment
//        return commentRepository.save(comment); //previous comment save method
        Comment saved = commentRepository.save(comment);
        User postAuthor = userRepository.findByUsername(post.getAuthor()).orElse(null);
        if (postAuthor != null && postAuthor.getEmail() != null) {
            emailService.send(postAuthor.getEmail(), "New Comment!", "Check out new comments on your post!!!");
        }

        return saved;
    }
}
