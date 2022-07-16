package com.example.userservice.controller;

import com.example.userservice.dto.UserRequest;
import com.example.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody UserRequest userRequest){
        userService.createUser(userRequest);
    }
}