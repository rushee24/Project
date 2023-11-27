package com.example.mySpringProject.Service;

import com.example.mySpringProject.model.User;
import com.example.mySpringProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User addUser(User user) {
          User name= userRepository.save(user);
          return name;
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public boolean isValidUser(String username, String password) {
    // Retrieve the user from your data source (e.g., a database)
    User user = userRepository.findByUsername(username);

    if (user != null) {
        // User found, check if the provided password matches the stored password
        return user.getPassword().equals(password);
    }

    // User not found or password does not match
    return false;
}

}
