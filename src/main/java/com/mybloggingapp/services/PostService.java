package com.mybloggingapp.services;

import com.mybloggingapp.entities.Post;
import com.mybloggingapp.payloads.PostDto;

import java.util.List;

public interface PostService {

    //create

    PostDto createPost(PostDto postDto);

    //update

    Post updatePost(PostDto postDto, Integer postId);

    //delete

    void deletePost(Integer postId);

    //get all posts

    List<PostDto> getAllPost();

    //get single post
    PostDto getPostById(Integer postId);

    //get all posts by category

    List<PostDto> getPostByCategory(Integer categoryId);

    //get all posts by user

    List<Post> getPostByUser(Integer userId);

    //search posts
    List<Post> searchPost(String keyword);


}
