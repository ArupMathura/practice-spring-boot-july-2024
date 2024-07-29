package com.example.practiceSpringBoot.service;

import com.example.practiceSpringBoot.entity.User;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
@Service
public class UserService {
    List<User> userList = Arrays.asList(
            new User(101, "arup", "mathura", "arup@gmail.com"),
            new User(102, "riya", "das", "riya@gmail.com"),
            new User(103, "ramu", "saha", "ramu@gmail.com")
    );

    /*---- get all users ----*/
    public List<User> getUserList() {
        return userList;
    }

    /*---- get user by id ----*/
    public User getUserById(int userId) {
        return userList.stream()
                .filter(ref -> ref.getId()==userId)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("user with id " + userId + " not found"));
    }

}
