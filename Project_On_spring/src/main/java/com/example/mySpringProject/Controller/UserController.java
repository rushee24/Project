package com.example.mySpringProject.Controller;

//package com.example.myspringproject.Controller;

import com.example.mySpringProject.Service.UserService;
import com.example.mySpringProject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    // @GetMapping("/login")
    // public String loginPage(Model model) {
    //     // Display the login form
    //     model.addAttribute("user", new User()); // Initialize a new User object
    //     return "login";
    // }

    @PostMapping("/login")
    public String login(@ModelAttribute User user, Model model) {
        // Perform login logic here (e.g., check if the provided username and password
        // are correct)
        if (userService.isValidUser(user.getUsername(), user.getPassword())) {
            return "redirect:/home"; // Redirect to the home page upon successful login
        } else {
            model.addAttribute("error", "Incorrect username or password.");
            return "login"; // Stay on the login page with an error message
        }
    }

    @GetMapping("/home")
    public String homePage() {
        // Display the home page after successful login
        return "home";
    }

    @GetMapping("/login")
    public String logink() {
        return "redirect:/home";
    }

    @GetMapping("/users") // showing table
    public String listUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "userview"; // Create a user list view
    }

    @GetMapping("/users/{id}") // it is selecting particullar value in table
    public String getUser(@PathVariable Long id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("users", user);
        return "userView"; // Create a user details view
    }

    @GetMapping("/register")
    public String registrationForm() {
        return "registration"; // Display the registration form
    }

    @PostMapping("/register") // inserting the data
    public String addUser(@ModelAttribute User user) {
        userService.addUser(user);
        return "redirect:/login"; // Redirect to the user list after adding
    }

    @GetMapping("/deleteUser/{id}") // deleting the particullar id
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "redirect:/home"; // Redirect to the user list after deleting
    }

}
