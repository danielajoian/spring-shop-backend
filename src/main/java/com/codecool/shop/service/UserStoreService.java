package com.codecool.shop.service;

import com.codecool.shop.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserStoreService {

    private List<User> users = new ArrayList<>(Arrays.asList(
        new User(
            0,
            "test@test.com",
            "0733333333",
            "Test Seller"
        ),
        new User(
            1,
            "gigi92@gmail.com",
            "0723647123",
            "Gigi Gigescu"),
        new User(
            2,
            "fotbalistul1982@outlook.com",
            "0754123321",
            "Cristi Costescu"
        ),
        new User(
            3,
            "magnat_bogat@saracilor.ro",
            "072222222",
            "Louis Versace"
        )
    ));

    public List<User> getUsers() {
        return users;
    }

    public User getUserById(int userId) {
        return users.stream()
            .filter(u -> u.getId() == userId)
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("User with ID " + userId + " not found"));
    }
}
