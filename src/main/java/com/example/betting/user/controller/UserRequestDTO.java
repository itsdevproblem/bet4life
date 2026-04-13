package com.example.betting.user.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDTO {
    private Long id;

    private String username;

    private String password;

    private String email;

    private Integer age;
}
