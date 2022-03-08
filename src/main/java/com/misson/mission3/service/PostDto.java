package com.misson.mission3.service;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class PostDto {
    private Long id;
    private String title;
    private String content;
    private String writer;
    private Long boardId;
    private Long userId;

    public PostDto() {
    }

    public PostDto(Long id, String title, String content, String writer, Long boardId, Long userId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.boardId = boardId;
        this.userId = userId;
    }


}
