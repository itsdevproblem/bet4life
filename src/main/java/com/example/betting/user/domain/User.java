package com.example.betting.user.domain;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class User {

    private Long id;

    private String username;

    private String password;

    private String email;

    private Integer age;

    public void updateAge(int i) {
        age = i;
    }
}
