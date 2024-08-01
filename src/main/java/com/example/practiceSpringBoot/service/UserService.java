package com.example.practiceSpringBoot.service;

import com.example.practiceSpringBoot.dto.UserDTO;
import com.example.practiceSpringBoot.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserDTO addUser(UserDTO userDto);

    List<UserDTO> getAllUsers();

    UserDTO getUserById(int userId);

    UserDTO updateUser(int userId, UserDTO userDTO);

    void deleteUser(int userId);
}
