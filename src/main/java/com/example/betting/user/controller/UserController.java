package com.example.betting.user.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.betting.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    
    private final UserRepository userRepository;

    @ResponseBody
    @GetMapping("/a")
    public ResponseEntity<Object> a() {
        userRepository.findAll();
        userRepository.searchUsers("BTS",20);
        userRepository.searchUsers1("BTS",20);
        userRepository.searchUsers2("BTS",20);
        userRepository.searchUsers3("BTS",20);
        return ResponseEntity.ok().build();
    }
 }
