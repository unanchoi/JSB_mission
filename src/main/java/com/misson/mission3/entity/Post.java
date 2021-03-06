package com.misson.mission3.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity@Table(name = "post") @Getter @Setter
public class Post {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String writer;
    private String content;

    @ManyToOne(
            targetEntity = Board.class,
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "board_id")
    private Board board;


    @ManyToOne(
            targetEntity = User.class,
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "user_id")
    private User user;


    public Post(Long id, String writer, String content, Board board, User user) {
        this.id = id;
        this.writer = writer;
        this.content = content;
        this.board = board;
        this.user = user;
    }

    public Post() {
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", writer='" + writer + '\'' +
                ", content='" + content + '\'' +
                ", board=" + board +
                '}';
    }
}
