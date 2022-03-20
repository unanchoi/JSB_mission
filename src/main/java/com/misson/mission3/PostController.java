package com.misson.mission3;

import com.google.gson.Gson;
import com.misson.mission3.aspect.LogExecutionTime;
import com.misson.mission3.service.PostDto;
import com.misson.mission3.service.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("post")
public class PostController {

    private static final Logger logger = LoggerFactory.getLogger(PostController.class);
    private final PostService postService;

    public PostController(
            @Autowired PostService postService,
            @Autowired Gson gson
    ){
        this.postService = postService;
        logger.info(gson.toString());
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void  createPost(@RequestBody PostDto dto){
        this.postService.createPost(dto);
    }

    @LogExecutionTime
    @GetMapping("{id}")
    public PostDto readPost(
            @PathVariable("id") Long id
    ){
    return this.postService.readPost(id);
    }

    @LogExecutionTime
    @GetMapping("")
    public List<PostDto> readPostAll(){
        return this.postService.readPostAll();
    }


    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping("{id}")
    public void updatePost(
            @PathVariable("id") Long id,
            @RequestBody PostDto dto
    ){
        this.postService.updatePost(id, dto);
    }




    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deletePost(
        @PathVariable("id") Long id
    ){
       logger.info("deletePost, id: {}", id);
        this.postService.deletePost(id);
    }

    @GetMapping("test-log")
    public void testLog() {
        logger.trace("TRACE Log Message");
        logger.debug("DEBUG Log Message");
        logger.info("INFO Log Message");
        logger.warn("WARN Log Message");
        logger.error("ERROR Log Message");
    }
}
