package com.greenchilli.blog.controller;

import com.greenchilli.blog.payload.PostDto;
import com.greenchilli.blog.security.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PostController {
    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/posts")
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto){
        PostDto dto = postService.createPost(postDto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }
    @GetMapping("/posts/{postId}")
    public ResponseEntity<PostDto> getPostById(@PathVariable Long postId){
       PostDto dto = postService.getPostById(postId);
       return new ResponseEntity<>(dto,HttpStatus.OK);
    }
    @PutMapping("/posts/{postId}")
    public ResponseEntity<PostDto> updatePostById(@PathVariable Long postId, @RequestBody PostDto postDto){
        PostDto dto = postService.updatePostById(postId,postDto);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}
