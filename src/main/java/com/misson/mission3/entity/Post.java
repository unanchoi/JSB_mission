package com.misson.mission3.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity@Table(name = "post")
@Getter @Setter
public class Post {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String writer;
    private String content;




}
