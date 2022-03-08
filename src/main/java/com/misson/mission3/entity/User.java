package com.misson.mission3.entity;

import lombok.Getter;
import lombok.Setter;

import javax.lang.model.type.ArrayType;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
@Getter@Setter
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(
            targetEntity = Post.class,
            fetch = FetchType.LAZY,
            mappedBy = "user"
    )
    @Column(name = "user_name")
    private  List<Post> post = new ArrayList<>();

    public User(Long id, String name, List<Post> post) {
        this.id = id;
        this.name = name;
        this.post = post;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", post=" + post +
                '}';
    }
}
