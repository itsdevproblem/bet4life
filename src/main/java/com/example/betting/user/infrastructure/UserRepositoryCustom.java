package com.example.betting.user.infrastructure;

import java.util.List;

import com.example.betting.user.dto.UserSimpleDto;
import com.example.betting.user.infrastructure.entity.UserEntity;
import com.querydsl.core.Tuple;

public interface UserRepositoryCustom {
    List<UserEntity> searchUsers(String username, Integer age);
    List<Tuple> searchUsers1(String username, Integer age);
    List<UserSimpleDto> searchUsers2(String username, Integer age);
    List<Long> searchUsers3(String username, Integer age);
}
