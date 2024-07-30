package com.example.practiceSpringBoot.controller;

import com.example.practiceSpringBoot.entity.User;
import com.example.practiceSpringBoot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getUserList() {
        return userService.getUserList();
    }

    @GetMapping("/{userId}")
    public User getUserById(@PathVariable int userId) {
        return userService.getUserById(userId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @PutMapping("/{userId}")
    @ResponseStatus(HttpStatus.CREATED)
    public User updateUser(@PathVariable int userId, @RequestBody User user) {
        return userService.updateUser(userId, user);
    }

    @DeleteMapping("/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteUser(@PathVariable int userId) {
        return userService.deleteUser(userId);
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleRuntimeException(RuntimeException ex) {
        return ex.getMessage();
    }

}
