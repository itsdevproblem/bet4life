package com.example.betting.user.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.betting.user.service.UserService;
import com.example.betting.user.vo.User;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    
    private final UserService userService;

    @GetMapping("/a")
    public ResponseEntity<Object> a() {
        userService.list();
        // userRepository.searchUsers("BTS",20);
        // userRepository.searchUsers1("BTS",20);
        // userRepository.searchUsers2("BTS",20);
        // userRepository.searchUsers3("BTS",20);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/b")
    public ResponseEntity<Object> b() {
        userService.save(
            User.builder()
            .username("username")
            .age(1)
            .email("email")
            .password("password")
            .build());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/c")
    public ResponseEntity<Object> c() {
        return ResponseEntity.ok(userService.getUser(1L));
    }

    @GetMapping("/d")
    public User d() {
        return userService.editAge();
    }
 }
