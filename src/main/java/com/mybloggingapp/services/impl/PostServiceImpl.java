package com.mybloggingapp.services.impl;

import com.mybloggingapp.entities.Post;
import com.mybloggingapp.exceptions.ResourceNotFoundException;
import com.mybloggingapp.payloads.PostDto;
import com.mybloggingapp.repositories.PostRepo;
import com.mybloggingapp.services.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepo postRepo;

    @Autowired
    private ModelMapper modelMapper;

    // Service to create a post
    @Override
    public PostDto createPost(PostDto postDto) {

        Post post = this.modelMapper.map(postDto, Post.class);
        Post uploadedPost = this.postRepo.save(post);
        return this.modelMapper.map(uploadedPost, PostDto.class);
    }

    //Service to update the post
    @Override
    public Post updatePost(PostDto postDto, Integer postId) {

        Post post = this.postRepo.findById(postId).
                orElseThrow(()->new ResourceNotFoundException("Post","Post Id",postId));
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        Post updatedPost = this.postRepo.save(post);
        return this.modelMapper.map(updatedPost,Post.class);
    }

    //Service to delete the post
    @Override
    public void deletePost(Integer postId) {
        Post post = this.postRepo.findById(postId)
                .orElseThrow(()->new ResourceNotFoundException("Post","Post Id",postId));
        this.postRepo.delete(post);

    }

    //Service to get all posts
    @Override
    public List<PostDto> getAllPost() {
        List<Post> posts = this.postRepo.findAll();
        List<PostDto> postDtos = posts.stream().map((post)->this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());

        return postDtos;
    }

    // service to get post by Id.
    @Override
    public PostDto getPostById(Integer postId) {
        Post post = this.postRepo.findById(postId)
                .orElseThrow(()->new ResourceNotFoundException("Post","Post Id",postId));
        return this.modelMapper.map(post,PostDto.class);
    }

    //Service to get post according to Category
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
