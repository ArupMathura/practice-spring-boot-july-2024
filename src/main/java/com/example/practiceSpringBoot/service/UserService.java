package com.example.practiceSpringBoot.service;

import com.example.practiceSpringBoot.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User addUser(User user);

    List<User> getAllUsers();

    Optional<User> getUserById(int userId);

    User updateUser(int userId, User user);

    void deleteUser(int userId);
}
