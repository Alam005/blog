package com.greenchilli.blog.payload;

import lombok.Data;

@Data
public class PostDto {
    private Long id;
    private String title;
    private String content;
}
