package com.example.betting.user.service;

import java.util.List;

import com.example.betting.user.controller.UserRequestDTO;
import com.example.betting.user.domain.User;
import com.example.betting.user.infrastructure.entity.UserEntity;
import com.example.betting.user.service.port.UserRepository;
import lombok.Builder;
import org.springframework.stereotype.Service;

import com.example.betting.user.infrastructure.UserJpaRepository;
import com.example.betting.user.controller.port.UserService;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Builder
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    
    private final UserRepository userRepository;

    public User getUser(Long id) {
        return userRepository.getUser(id).orElseThrow();
    }

    public List<User> list() {
        return userRepository.list();
    }

    @Override
    public User save(UserRequestDTO requestDTO) {
        return userRepository.save(
                User.builder()
                .username(requestDTO.getUsername())
                .password(requestDTO.getPassword())
                .email(requestDTO.getEmail())
                .age(requestDTO.getAge())
                .build()
        );
    }

    @Override
    @Transactional
    public User editAge(UserRequestDTO requestDTO) {
        User ss = userRepository.getUser(requestDTO.getId()).orElseThrow();

        ss.updateAge(requestDTO.getAge());

        return ss;
    }
}
