package com.mybloggingapp.repositories;

import com.mybloggingapp.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository <Comment, Integer> {

}
