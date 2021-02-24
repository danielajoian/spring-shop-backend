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

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(User user, long id) {
        User userToUpdate = userRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("No User found with id: " + id)
        );

        userToUpdate.setEmail(user.getEmail());
        userToUpdate.setPhone(user.getPhone());
        userToUpdate.setFirstName(user.getFirstName());
        userToUpdate.setLastName(user.getLastName());
        userToUpdate.setPassword(user.getPassword());
        userToUpdate.setConfirmPassword(userToUpdate.getConfirmPassword());
        userToUpdate.setProducts(user.getProducts());

        return userRepository.save(userToUpdate);
    }

    public User deleteUser(long id) {
        User userToDelete = userRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("No User found with id: " + id)
        );
        userRepository.delete(userToDelete);
        return userToDelete;
    }
}
