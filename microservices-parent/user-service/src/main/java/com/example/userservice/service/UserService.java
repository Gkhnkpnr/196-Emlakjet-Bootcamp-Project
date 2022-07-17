package com.example.userservice.service;

import com.example.userservice.dto.UserRequest;
import com.example.userservice.entity.Role;
import com.example.userservice.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User> getUsers();
}
