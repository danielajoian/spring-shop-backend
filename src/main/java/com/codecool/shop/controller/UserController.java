package com.codecool.shop.controller;

import com.codecool.shop.model.User;
import com.codecool.shop.service.UserStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/user")
public class UserController {

    private final UserStoreService userStoreService;

    @Autowired
    public UserController(UserStoreService userStoreService) {
        this.userStoreService = userStoreService;
    }

    @GetMapping("/")
    public List<User> getUsers() {
        return userStoreService.getUsers();
    }

    @GetMapping("/{userId}")
    public User getSingleUser(@PathVariable("userId") int userId) {
        return userStoreService.getUserById(userId);
    }
}
