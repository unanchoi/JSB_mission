package com.misson.mission3.service;

import com.misson.mission3.PostDao;
import com.misson.mission3.entity.Post;
import com.misson.mission3.repository.PostRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    private static final Logger logger = LoggerFactory.getLogger(PostService.class);
    private final PostDao postDao;

    public PostService(PostDao postDao) {
        this.postDao = postDao;
    }

    public void createPost(PostDto postDto) {
        this.postDao.createPost(postDto);
    }

    public PostDto readPost(Long id) {
        Post post = this.postDao.readPost(id);

        return new PostDto(
                post.getId(),
                post.getContent(),
                post.getWriter(),
                post.getBoard() == null ? 0 : (post.getBoard().getId()),
                post.getUser() == null ? 0 : (post.getUser().getId())
        );
    }

    public List<PostDto> readPostAll() {
        Iterator<Post> iterator = this.postDao.readPostAll();
        List<PostDto> postDtoList = new ArrayList<>();

        while (iterator.hasNext()) {
            Post post = iterator.next();
            postDtoList.add(
                    new PostDto(
                            post.getId(),
                            post.getContent(),
                            post.getWriter(),
                            post.getBoard() == null ? 0 : (post.getBoard().getId()),
                            post.getUser() == null ? 0 : (post.getUser().getId())
                    ));
        }
        return postDtoList;
    }

    public void updatePost(Long id, PostDto postDto) {
        this.postDao.updatePost(id, postDto);
    }

    public void deletePost(Long id) {
        Optional<Post> targetEntity = this.postRepository.findById((long) id);
        if (targetEntity.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        this.postRepository.delete(targetEntity.get());
    }


}

