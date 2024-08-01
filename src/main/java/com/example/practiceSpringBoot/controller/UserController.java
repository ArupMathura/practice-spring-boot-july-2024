package com.example.practiceSpringBoot.controller;

import com.example.practiceSpringBoot.dto.UserDTO;
import com.example.practiceSpringBoot.entity.User;
import com.example.practiceSpringBoot.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@Tag(name = "Rest Controller")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @PostMapping
    public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userDto) {
        UserDTO savedUserDto = userService.addUser(userDto);
//        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUserDto);
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> userList = userService.getAllUsers();
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable int id) {
        UserDTO userDTO = userService.getUserById(id);
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable("id") int userId, @RequestBody UserDTO userDTO) {
        UserDTO updatedUser = userService.updateUser(userId, userDTO);
        return new ResponseEntity<>(updatedUser, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") int userId) {
        userService.deleteUser(userId);
        return new ResponseEntity<>("User with Id " + userId + " deleted successfully.", HttpStatus.OK);
    }
}
