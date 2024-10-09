package com.example.rest_service.controller;


import com.example.rest_service.dto.CreateUserDto;
import com.example.rest_service.dto.UpdateUserDto;
import com.example.rest_service.model.User;
import com.example.rest_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping ("/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @PostMapping
    public User createUser(@RequestBody CreateUserDto user) {
        return userService.createUser(user);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody UpdateUserDto user) {
        return ResponseEntity.ok(userService.updateUser(id, user));
    }
}
