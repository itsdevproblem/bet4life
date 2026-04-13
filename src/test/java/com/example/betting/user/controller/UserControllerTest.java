package com.example.betting.user.controller;

import com.example.betting.mock.UserContainer;
import com.example.betting.ship.domain.Ship;
import com.example.betting.user.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class UserControllerTest {

    private UserContainer userContainer;

    @BeforeEach
    void init(){
        userContainer = UserContainer.builder().build();
    }

    @Test
    void userList를_조회할_수_있다() {
        userContainer.userRepository.save(User.builder()
                .username("test123")
                .password("1234")
                .email("test@test.com")
                .age(27)
                .build()
        );

        userContainer.userRepository.save(User.builder()
                .username("qwer123")
                .password("1234")
                .email("qwer123@test.com")
                .age(15)
                .build()
        );

        Map<String, Object> result = userContainer.userController.a();


        List<User> data = (List<User>) result.get("result");
        assertThat(data.size()).isEqualTo(2);
        assertThat(data.get(0).getId()).isEqualTo(1L);
        assertThat(data.get(0).getUsername()).isEqualTo("test123");
        assertThat(data.get(0).getAge()).isEqualTo(27);
        assertThat(data.get(1).getEmail()).isEqualTo("qwer123@test.com");
        assertThat(data.get(1).getPassword()).isEqualTo("1234");
        assertThat(data.get(1).getUsername()).isEqualTo("qwer123");


    }

    @Test
    void user_저장할_수_있다() {
        UserRequestDTO dto = UserRequestDTO.builder()
                .username("qwer123")
                .password("1234")
                .email("qwer123@test.com")
                .age(15)
                .build();


        Map<String, Object> result = userContainer.userController.b(dto);
        assertThat(result.get("result")).isEqualTo("success");
        Optional<User> oUser = userContainer.userRepository.getUser(1L);
        assertThat(oUser.isPresent()).isEqualTo(true);
        User user = oUser.get();
        assertThat(user.getId()).isEqualTo(1L);
        assertThat(user.getPassword()).isEqualTo("1234");
        assertThat(user.getAge()).isEqualTo(15);
    }

    @Test
    void id로_조회할_수_있다() {

        userContainer.userRepository.save(User.builder()
                .username("qwer123")
                .password("1234")
                .email("qwer123@test.com")
                .age(15)
                .build()
        );

        UserRequestDTO dto = UserRequestDTO.builder()
                .id(1L)
                .build();


        User user = userContainer.userController.c(dto);

        assertThat(user.getUsername()).isEqualTo("qwer123");
        assertThat(user.getEmail()).isEqualTo("qwer123@test.com");
        assertThat(user.getAge()).isEqualTo(15);
    }


}