package com.mybloggingapp.controllers;

import com.mybloggingapp.payloads.PostDto;
import com.mybloggingapp.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/posts")
@RestController
public class PostController {


    @Autowired
    private PostService postService;

    //POST - Create post
    @PostMapping("/")
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto) {
        PostDto createPostDto = this.postService.createPost(postDto);
        return new ResponseEntity<>(createPostDto, HttpStatus.CREATED);
    }

    //

}
