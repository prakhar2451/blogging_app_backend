package com.mybloggingapp.services.impl;

import com.mybloggingapp.entities.Post;
import com.mybloggingapp.payloads.PostDto;
import com.mybloggingapp.repositories.PostRepo;
import com.mybloggingapp.services.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepo postRepo;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public PostDto createPost(PostDto postDto) {

        Post post = this.modelMapper.map(postDto, Post.class);
        Post uploadedPost = this.postRepo.save(post);
        return this.modelMapper.map(uploadedPost, PostDto.class);
    }

    @Override
    public Post updatePost(PostDto postDto, Integer postId) {
        return null;
    }

    @Override
    public void deletePost(Integer postId) {

    }

    @Override
    public List<Post> getAllPost() {
        return null;
    }

    @Override
    public Post getPostById(Integer postId) {
        return null;
    }

    @Override
    public List<Post> getPostByCategory(Integer categoryId) {
        return null;
    }

    @Override
    public List<Post> getPostByUser(Integer userId) {
        return null;
    }

    @Override
    public List<Post> searchPost(String keyword) {
        return null;
    }
}
