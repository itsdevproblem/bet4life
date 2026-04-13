package com.example.betting.user.infrastructure.impl;

import com.example.betting.ship.infrastructure.ShipJpaRepository;
import com.example.betting.ship.infrastructure.ShipRepositoryCustom;
import com.example.betting.user.domain.User;
import com.example.betting.user.infrastructure.UserJpaRepository;
import com.example.betting.user.infrastructure.UserRepositoryCustom;
import com.example.betting.user.infrastructure.entity.UserEntity;
import com.example.betting.user.service.port.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final UserJpaRepository userJpaRepository;
    private final UserRepositoryCustom userRepositoryCustom;

    @Override
    public Optional<User> getUser(Long id) {
        return userJpaRepository.findById(id).map(UserEntity::toModel);
    }

    @Override
    public List<User> list() {
        return userJpaRepository.findAll().stream().map(UserEntity::toModel).toList();
    }

    @Override
    public User save(User user) {
        return userJpaRepository.save(UserEntity.from(user)).toModel();
    }


}
