package com.mybloggingapp.controllers;

import com.mybloggingapp.entities.Comment;
import com.mybloggingapp.payloads.ApiResponse;
import com.mybloggingapp.payloads.CommentDto;
import com.mybloggingapp.services.CommentService;
import jakarta.persistence.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class CommentController {

    @Autowired
    public CommentService commentService;

    @PostMapping("/post/{postId}/comments")
    public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto comment, @PathVariable Integer postId){

       CommentDto createComment = this.commentService.createComment(comment, postId);
       return new ResponseEntity<>(createComment, HttpStatus.CREATED);
    }

    @DeleteMapping("/comments/{commentId}")
    public ResponseEntity<ApiResponse> deleteComment(@PathVariable Integer commentId) {

        this.commentService.deleteComment(commentId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("Comment removed successfully", true),HttpStatus.OK);
    }

}
