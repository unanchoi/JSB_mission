package com.misson.mission3.service;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter@Setter
public class PostDto {
    private Long id;

    @NotBlank
    @Size(max=400)
    private String content;

    @NotBlank
    @Size(max=20, min=3)
    private String writer;

    private Long boardId;
    private Long userId;

    public PostDto() {
    }

    public PostDto(Long id, String content, String writer, Long boardId, Long userId) {
        this.id = id;
        this.content = content;
        this.writer = writer;
        this.boardId = boardId;
        this.userId = userId;
    }


}
