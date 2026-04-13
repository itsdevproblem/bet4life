package com.example.betting.user.controller;

import com.example.betting.ship.controller.ShipRequestDto;
import com.example.betting.ship.domain.Ship;
import com.example.betting.user.domain.User;
import com.example.betting.user.infrastructure.entity.UserEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.betting.user.controller.port.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    
    private final UserService userService;

    @GetMapping("/a") // list all
    public Map<String, Object> a() {
        userService.list();

        List<User> data = userService.list();

        Map<String, Object> result = new HashMap<>();
        result.put("result", data);
        return result;
    }

    @GetMapping("/b") // insert (add)
    public Map<String, Object> b(@RequestBody UserRequestDTO requestDto) {
        User ss = userService.save(requestDto);

        Map<String, Object> result = new HashMap<>();
        result.put("result", ss == null ? "fail" : "success");
        return result;
    }

    @GetMapping("/c")
    public User c(@RequestBody UserRequestDTO requestDto) {

        return userService.getUser(requestDto.getId());
    }

    @GetMapping("/d")
    public Map<String, Object> d(@RequestBody UserRequestDTO requestDTO) {

        User ss = userService.editAge(requestDTO);
        Map<String, Object> result = new HashMap<>();
        result.put("result", ss == null ? "fail" : "success");

        return result;
    }
 }
