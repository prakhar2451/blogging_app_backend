package com.mybloggingapp.controllers;

import com.mybloggingapp.entities.Post;
import com.mybloggingapp.payloads.ApiResponse;
import com.mybloggingapp.payloads.PostDto;
import com.mybloggingapp.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    //PUT - Update Post

    @PutMapping("/{postId}")
    public ResponseEntity<Post> updatePost(@RequestBody PostDto postDto, @PathVariable ("postId") Integer postId) {
        Post updatedPost = this.postService.updatePost(postDto, postId);
        return ResponseEntity.ok(updatedPost);
    }

    //DELETE - delete post
    @DeleteMapping("/{postId}")
    public ResponseEntity<ApiResponse> deletePost(@PathVariable("postId") Integer postId) {
        this.postService.deletePost(postId);
        return new ResponseEntity(new ApiResponse("Post deleted Successfully",true), HttpStatus.OK);
    }
    //GET - Get all posts
    @GetMapping("/")
    public ResponseEntity<List<PostDto>> getAllPost() {
        return ResponseEntity.ok(this.postService.getAllPost());
    }

    //GET - get single post by Id
    @GetMapping("/{postId}")
    public ResponseEntity<PostDto> getPostById(@PathVariable("postId") Integer postId) {
        return ResponseEntity.ok(this.postService.getPostById(postId));

    }
    //GET- get post according to category

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<PostDto>> getPostByCategory(@PathVariable("categoryId") Integer categoryId) {
        return ResponseEntity.ok(this.postService.getPostByCategory(categoryId));
    }





}
