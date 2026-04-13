package com.example.betting.user.controller.port;

import java.util.List;

import com.example.betting.user.controller.UserRequestDTO;
import com.example.betting.user.domain.User;
import com.example.betting.user.infrastructure.entity.UserEntity;

public interface UserService {
    
    public User getUser(Long id);
    public List<User> list();
    public User save(UserRequestDTO userRequestDTO);
    public User editAge(UserRequestDTO requestDTO);
}
