package com.example.betting.user.service;

import java.util.List;

import com.example.betting.user.vo.User;

public interface UserService {
    
    public User getUser(Long id);
    public List<User> list();
    public User save(User user);
    public User editAge();
}
