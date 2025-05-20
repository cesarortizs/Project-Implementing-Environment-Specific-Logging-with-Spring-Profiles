package com.activity.four.Services;

import com.activity.four.Controllers.UserController;
import com.activity.four.Exceptions.ResourceNotFoundException;
import com.activity.four.Models.User;
import com.activity.four.Repositories.UserRepository;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class UserService {

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserRepository userRepository;

    public List<User> getAllUsers()
    {
        List<User> users = userRepository.findAll();
        logger.info("All users retrieved succesfully");

        return users;
    }

    public void addNewUser(@Valid @RequestBody User newUser)
    {
        userRepository.save(newUser);
        logger.info("New user added succesfully");
    }

    public void deleteUser(@PathVariable("id") int id)
    {
        User existingUser = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No user found with id: " + id));
        userRepository.deleteById(id);
        logger.info("User deleted succesfully");
    }
}
