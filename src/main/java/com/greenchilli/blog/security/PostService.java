package com.greenchilli.blog.security;

import com.greenchilli.blog.entity.Post;
import com.greenchilli.blog.payload.PostDto;

public interface PostService {
    PostDto createPost(PostDto postDto);
    PostDto mapToDto(Post post);
    Post mapToEntity(PostDto postDto);

    PostDto getPostById(Long postId);

    PostDto updatePostById(Long postId, PostDto postDto);
}
