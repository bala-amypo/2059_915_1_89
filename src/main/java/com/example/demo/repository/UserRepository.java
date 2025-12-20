package com.example.demo.repository;

import com.example.demo.entity.User;

public interface UserRepository {
    User findById(Long id);
    User findByUsername(String username);
    User save(User user);
}
