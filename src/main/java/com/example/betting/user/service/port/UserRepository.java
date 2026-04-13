package com.example.betting.user.service.port;

import com.example.betting.user.domain.User;
import com.example.betting.user.infrastructure.entity.UserEntity;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    public Optional<User> getUser(Long id);

    public List<User> list();

    public User save(User user);

}
