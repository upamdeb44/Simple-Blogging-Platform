package com.example.bloggingPlatform.controller;

import com.example.bloggingPlatform.model.Post;
import com.example.bloggingPlatform.service.PostService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/posts")

public class PostController {
    private final PostService postService;

    public PostController (PostService postService){
        this.postService = postService;
    }

    @GetMapping
    public List<Post> getPosts(){
        return postService.getAllPosts();
    }

    @PostMapping
    public Post addPost(@RequestBody Post post){
        return postService.createPost(post);
    }

    @PutMapping("/{id}")
    public Post updatePost(@PathVariable Long id, @RequestBody Post post){
        return postService.updatePost(id,post);
    }

    @PreAuthorize("hasRole('Admin')")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        postService.deletePost(id);
    }

}
