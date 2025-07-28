package org.example.panacea.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.example.panacea.dto.UserInput;
import org.example.panacea.entity.User;
import org.example.panacea.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/{userId}")
    @Operation(summary = "get a user")
    public User getUser(@PathVariable Long userId) {
        return userService.findById(userId).orElseThrow();
    }

    @GetMapping("/users")
    @Operation(summary = "get a user")
    public List<User> getUser() {
        return userService.findAll();
    }


    @PostMapping("/users")
    @Operation(summary = "create a user")
    public User createUser(@RequestBody UserInput userInput) {
        return userService.save(userInput);
    }
}
