package com.example.betting.mock;

import com.example.betting.user.controller.UserController;
import com.example.betting.user.controller.port.UserService;
import com.example.betting.user.service.UserServiceImpl;
import com.example.betting.user.service.port.UserRepository;
import lombok.Builder;

public class UserContainer {

    public final UserRepository userRepository;

    public final UserService userService;

    public final UserController userController;

    @Builder
    public UserContainer(){
        this.userRepository = new FakeUserRepository();

        this.userService = UserServiceImpl.builder()
                .userRepository(userRepository)
                .build();

        this.userController = UserController.builder()
                .userService(userService)
                .build();
    }
}
