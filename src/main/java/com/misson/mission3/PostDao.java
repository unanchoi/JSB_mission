package com.misson.mission3;


import com.misson.mission3.entity.Post;
import com.misson.mission3.repository.PostRepository;
import com.misson.mission3.service.PostDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.util.Iterator;
import java.util.Optional;

@Repository
public class PostDao {
    private static final Logger logger = LoggerFactory.getLogger(PostDao.class);
    private final PostRepository postRepository;

    public PostDao(
            @Autowired PostRepository postRepository
    ) {
        this.postRepository = postRepository;
    }

    public void createPost(PostDto dto) {
        Post post = new Post();
        post.setContent(dto.getContent());
        post.setWriter(dto.getWriter());
        post.setBoard(null);
        this.postRepository.save(post);

    }

    public Post readPost(Long id) {
        Optional<Post> postEntity = this.postRepository.findById(id); // Optional -> Null point exception
        if (postEntity.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return postEntity.get();

    }

    public Iterator<Post> readPostAll() {
        return this.postRepository.findAll().iterator();
    }

    public void updatePost(Long id, PostDto dto) {
        Optional<Post> targetEntity = postRepository.findById(id);
        if (targetEntity.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        Post post = targetEntity.get();
        post.setContent(dto.getContent() == null ? post.getContent() : dto.getTitle());
        post.setWriter(dto.getWriter() == null ? post.getWriter() : dto.getWriter());
        this.postRepository.save(post);

    }

    public void deletePost(Long id) {
        Optional<Post> targetEntity = this.postRepository.findById(id);
        if (targetEntity.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        this.postRepository.delete(targetEntity.get());
    }


}

