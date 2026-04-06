package com.example.betting.user.vo;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "BT_USERS") // Oracle 예약어인 'USER' 대신 'USERS' 추천
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED) // JPA 기본 생성자
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(name = "user_seq", sequenceName = "USER_SEQ", allocationSize = 1)
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(length = 100)
    private String email;

    private Integer age;

    @Builder.Default // 빌더 사용 시 기본값 유지
    private LocalDateTime createdAt = LocalDateTime.now();
}
