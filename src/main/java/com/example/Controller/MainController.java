package com.example.Controller;

import com.example.Entity.User;
import com.example.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(path = "/add")
    public User addNewUser(@RequestParam String name, @RequestParam String email) {
        try {
            User user = new User();
            user.setName(name);
            user.setEmail(email);
            user = userRepository.save(user);
            return user;
        }
        catch (Exception ex) {
            throw ex;
        }
    }

    @RequestMapping(path = "/all")
    public Iterable<User> getAllUsers () {
        return userRepository.findAll();
    }
}
