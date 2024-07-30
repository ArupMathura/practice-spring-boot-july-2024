package com.example.practiceSpringBoot.service.impl;

import com.example.practiceSpringBoot.entity.User;
import com.example.practiceSpringBoot.repository.UserRepository;
import com.example.practiceSpringBoot.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(int userId) {
        return userRepository.findById(userId);
    }

    @Override
    public User updateUser(int userId, User user) {
        Optional<User> existingUser = userRepository.findById(userId);

        if (existingUser.isPresent()) {
            User updatedUser = existingUser.get();
            log.info("Existing User Data: {}", updatedUser);
            updatedUser.setFirstName(user.getFirstName());
            updatedUser.setLastName(user.getLastName());
            updatedUser.setEmail(user.getEmail());
            log.info("Updated User Data: {}", updatedUser);
            return userRepository.save(updatedUser);
        }
        else {
            throw new RuntimeException("User with ID " + userId + " not found.");
        }
    }

    @Override
    public String deleteUser(int userId) {
        Optional<User> existingUser = userRepository.findById(userId);

        if (existingUser.isPresent()) {
            userRepository.deleteById(userId);
            return "User with Id " + userId + " deleted successfully.";
        }
        else {
            throw new RuntimeException("User with ID " + userId + " not found.");
        }
    }


}
