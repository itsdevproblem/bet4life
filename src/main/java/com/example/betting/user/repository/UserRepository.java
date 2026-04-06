package com.example.betting.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.betting.user.vo.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, UserRepositoryCustom {
    
}
