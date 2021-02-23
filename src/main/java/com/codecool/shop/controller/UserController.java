package com.codecool.shop.controller;

import com.codecool.shop.model.User;
import com.codecool.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{userId}")
    public User getSingleUser(@PathVariable("userId") long userId) {
        return userService.findById(userId);
    }

    @PostMapping
    public User addUser(@RequestBody @Valid User user) {
        return userService.addUser(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@RequestBody @Valid User user, @PathVariable("id") long id) {
        return userService.updateUser(user, id);
    }

    @DeleteMapping("/{id}")
    public User deleteUser(@PathVariable("id") long id) {
        return userService.deleteUser(id);
    }
}
