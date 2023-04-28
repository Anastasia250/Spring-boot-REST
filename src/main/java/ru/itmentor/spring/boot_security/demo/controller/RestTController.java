package ru.itmentor.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.itmentor.spring.boot_security.demo.model.User;
import ru.itmentor.spring.boot_security.demo.service.UserService;

import java.security.Principal;
import java.util.List;

@RestController
public class RestTController {

    private UserService userService;

    @Autowired
    public RestTController(UserService userService) {
        this.userService = userService;
    }

    public RestTController() {
    }

    @GetMapping("/getUsers")
    public List<User> getUsers() {
        return userService.listUsers();
    }

    @GetMapping("/getUserNow")
    public User getUsers(Principal principal) {
        return (User) userService.loadUserByUsername(principal.getName());
    }

    @PostMapping("/adduser")
    public User addUser(@RequestBody User user) {
        userService.addUser(user);
        return user;
    }

    @PutMapping("/edit")
    public User editUser(@RequestBody User user) {
        if (user.getPassword().isEmpty()) {
            user.setPassword(userService.getUserById(user.getId()).getPassword());
        }
        userService.updateUser(user);
        return user;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable long id) {
        userService.deleteUser(id);
    }
}