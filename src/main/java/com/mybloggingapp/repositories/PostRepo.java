package com.mybloggingapp.repositories;

import com.mybloggingapp.entities.Category;
import com.mybloggingapp.entities.Post;
import com.mybloggingapp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, Integer> {

    List<Post> findByUser(User user);
    List<Post> findByCategory(Category category);
}
