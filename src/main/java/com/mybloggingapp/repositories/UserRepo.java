package com.mybloggingapp.repositories;
import com.mybloggingapp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Integer> {
    Optional<Object> findByEmail(String username);
}
