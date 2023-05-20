package com.mybloggingapp.repositories;
import com.mybloggingapp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
}
