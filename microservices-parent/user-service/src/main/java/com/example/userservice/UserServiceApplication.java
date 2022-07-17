package com.example.userservice;

import com.example.userservice.entity.Role;
import com.example.userservice.entity.User;
import com.example.userservice.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
@EnableEurekaClient
public class UserServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    /*@Bean
    CommandLineRunner run(UserService userService){
        return args -> {
            userService.saveRole(new Role(null,"ROLE_USER"));
            userService.saveRole(new Role(null,"ROLE_ADMIN"));

            userService.saveUser(new User(null,"John","Doe", "123456677","john@example.com","john", "1234",new ArrayList<>()));
            userService.saveUser(new User(null,"John1","Doe1", "1234566771","john1@example.com","john1", "12341",new ArrayList<>()));

            userService.addRoleToUser("john","ROLE_USER");
            userService.addRoleToUser("john1","ROLE_ADMIN");
        };
    }*/
}
