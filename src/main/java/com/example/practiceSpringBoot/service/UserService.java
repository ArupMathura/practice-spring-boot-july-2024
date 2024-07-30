package com.example.practiceSpringBoot.service;

import com.example.practiceSpringBoot.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
@Service
public class UserService {
    List<User> userList = new ArrayList<>(
            Arrays.asList(
            new User(101, "arup", "mathura", "arup@gmail.com"),
            new User(102, "riya", "das", "riya@gmail.com"),
            new User(103, "ramu", "saha", "ramu@gmail.com")
        )
    );

    /*---- get all users ----*/
    public List<User> getUserList() {
        return userList;
    }

    /*---- get user by id ----*/
    /*public User getUserById(int userId) {
        return userList.stream()
                .filter(ref -> ref.getId()==userId)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("user with id " + userId + " not found"));
    }*/

    public User getUserById(int id) {
        for (User user : userList) {
            if (user.getId() == id) {
                return user;
            }
        }
        throw new RuntimeException("User with ID " + id + " not found");
    }


    /*---- Add user with id, else it will take default 0 as id ----*/
    public String addUser(User user) {
        userList.add(user);
        return "User added successfully";
    }

    /*---- update user by id ----*/
    public User updateUser(int userId, User updateUser) {
        for (int i = 0; i < userList.size(); i++) {
            User user = userList.get(i);
            if (user.getId() == userId) {
                user.setFirstName(updateUser.getFirstName());
                user.setLastName(updateUser.getLastName());
                user.setEmail(updateUser.getEmail());
                return user;
            }
        }
        throw new RuntimeException("User with id " + userId + " not found.");
    }

    /*---- delete user by id ----*/
    /*public void deleteUser(int userId) {
        for (int i=0; i<userList.size(); i++) {
            User user = userList.get(i);
            if (user.getId()==userId) {
                userList.remove(i);
//                return "User deleted successfully";
                throw new RuntimeException("User deleted.");
            }
        }
//        return "User id " + userId + " not found";
        throw new RuntimeException("User with id " + userId + " not found.");
    }*/

    public String deleteUser(int id) {
        Iterator<User> iterator = userList.iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            if (user.getId() == id) {
                iterator.remove();
                return "User deleted successfully";
            }
        }
        throw new RuntimeException("User with ID " + id + " not found");
    }

}
