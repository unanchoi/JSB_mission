package com.misson.mission3.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "board")
@Getter
@Setter
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(
            targetEntity = Post.class,
            fetch = FetchType.LAZY,
            mappedBy = "board"
    )
    @Column(name = "board_name")
    private List<Post> post = new ArrayList<>();

    @Override
    public String toString() {
        return "Board{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", post=" + post +
                '}';
    }
}
