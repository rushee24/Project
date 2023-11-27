package com.example.mySpringProject.Service;

import java.util.List;

import com.example.mySpringProject.model.User;

public interface UserService {
    public User addUser(User user);

    User getUserById(Long id);
    List<User> getAllUsers();
    void deleteUser(Long id);

    public boolean isValidUser(String firstName, String password);
}
