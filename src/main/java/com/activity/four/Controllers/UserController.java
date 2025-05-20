package com.activity.four.Controllers;

import com.activity.four.Exceptions.ResourceNotFoundException;
import com.activity.four.Models.User;
import com.activity.four.Repositories.UserRepository;
import com.activity.four.Services.UserService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers()
    {
        return userService.getAllUsers();
    }

    @PostMapping("/users")
    public void addNewUser(@Valid @RequestBody User newUser)
    {
        userService.addNewUser(newUser);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable("id") int id)
    {
        userService.deleteUser(id);
    }
}
