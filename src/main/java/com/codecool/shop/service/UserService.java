package com.codecool.shop.service;

import com.codecool.shop.model.User;
import com.codecool.shop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User findById(long userId) {
        return userRepository.findById(userId).orElseThrow(
            () -> new IllegalArgumentException("No User found with id: " + userId)
        );
    }
}
