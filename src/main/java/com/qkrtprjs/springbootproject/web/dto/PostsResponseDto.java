package com.qkrtprjs.springbootproject.web.dto;


import com.qkrtprjs.springbootproject.domain.posts.Posts;
import lombok.Getter;

@Getter

public class PostsResponseDto {

    private Long id;
    private String title;
    private String content;
    private String author;

    public PostsResponseDto(Posts posts) {
        this.id = posts.getId();
        this.title = posts.getTitle();
        this.content = posts.getContent();
        this.author = posts.getAuthor();
    }
}
