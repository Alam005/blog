package com.greenchilli.blog.security.impl;

import com.greenchilli.blog.entity.Post;
import com.greenchilli.blog.exception.ResourceNotFoundException;
import com.greenchilli.blog.payload.PostDto;
import com.greenchilli.blog.repository.PostRepository;
import com.greenchilli.blog.security.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {
PostRepository postRepository;
ModelMapper modelMapper;

    public PostServiceImpl(PostRepository postRepository, ModelMapper modelMapper) {
        this.postRepository = postRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public PostDto createPost(PostDto postDto) {
        Post post = mapToEntity(postDto);
        Post postSaved = postRepository.save(post);

        PostDto dto = mapToDto(postSaved);
        return dto;
    }

    @Override
    public PostDto mapToDto(Post post) {
        PostDto postdto = modelMapper.map(post, PostDto.class);
        return postdto;
    }

    @Override
    public Post mapToEntity(PostDto postDto) {
        Post post = modelMapper.map(postDto, Post.class);
        return post;
    }

    @Override
    public PostDto getPostById(Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post not found with id: " + postId));
        PostDto postDto = mapToDto(post);
        return postDto;
    }

    @Override
    public PostDto updatePostById(Long postId, PostDto postDto) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post not found with id: " + postId));
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        Post updatedPost = postRepository.save(post);
        PostDto dto = mapToDto(updatedPost);
        return dto;
    }

}
