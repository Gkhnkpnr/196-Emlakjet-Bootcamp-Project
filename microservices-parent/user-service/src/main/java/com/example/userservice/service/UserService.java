package com.example.userservice.service;

import com.example.userservice.dto.UserRequest;
import org.springframework.stereotype.Service;

public interface UserService {
    void createUser(UserRequest userRequest);
}
