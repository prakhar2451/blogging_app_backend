package com.mybloggingapp.controllers;

import com.mybloggingapp.payloads.ApiResponse;
import com.mybloggingapp.payloads.PostDto;
import com.mybloggingapp.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/")
@RestController
public class PostController {


    @Autowired
    private PostService postService;

    //POST - Create post
    @PostMapping("/user/{userId}/category/{categoryId}/posts")
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto, @PathVariable Integer userId, @PathVariable Integer categoryId) {
        PostDto createPost = this.postService.createPost(postDto, userId, categoryId);
        return new ResponseEntity(createPost, HttpStatus.CREATED);
    }

    //PUT - Update Post

    @PutMapping("/{postId}")
    public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto, @PathVariable ("postId") Integer postId) {
        PostDto updatedPost = this.postService.updatePost(postDto, postId);
        return ResponseEntity.ok(updatedPost);
    }

    //DELETE - delete post
    @DeleteMapping("/posts/{postId}")
    public ApiResponse deletePost(@PathVariable("postId") Integer postId) {
        this.postService.deletePost(postId);
        return new ApiResponse("Post deleted Successfully",true);
    }
    //GET - Get all posts
    @GetMapping("/posts")
    public ResponseEntity<List<PostDto>> getAllPost() {
        return ResponseEntity.ok(this.postService.getAllPost());
    }

    //GET - get single post by Id
    @GetMapping("/posts/{postId}")
    public ResponseEntity<PostDto> getPostById(@PathVariable("postId") Integer postId) {
        return ResponseEntity.ok(this.postService.getPostById(postId));

    }

    //GET-get post according to category
    @GetMapping("/category/{categoryId}/posts")
    public ResponseEntity<List<PostDto>> getPostByCategory(@PathVariable("categoryId") Integer categoryId) {
       List<PostDto> posts = this.postService.getPostByCategory(categoryId);
       return new ResponseEntity<List<PostDto>>(posts, HttpStatus.OK);
    }

    //get post by user

    @GetMapping("/user/{userId}/posts")
    public ResponseEntity<List<PostDto>> getPostByUser(@PathVariable Integer userId){

        List<PostDto> posts = this.postService.getPostByUser(userId);
        return new ResponseEntity<List<PostDto>>(posts, HttpStatus.OK);

    }





}
