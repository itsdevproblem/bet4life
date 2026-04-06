package com.example.betting.user.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.betting.user.repository.UserRepository;
import com.example.betting.user.service.UserService;
import com.example.betting.user.vo.User;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    
    private final UserRepository userRepository;

    public User getUser(Long id) {
        return userRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));
    }

    public List<User> list() {
        return userRepository.findAll();
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public User editAge() {
        User user = getUser(1L);
        user.setAge(2);
        return user;
    }
}
