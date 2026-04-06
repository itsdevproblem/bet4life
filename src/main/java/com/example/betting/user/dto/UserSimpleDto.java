package com.example.betting.user.dto;

import com.querydsl.core.annotations.QueryProjection;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserSimpleDto {
    private Long id;
    private Integer age;

    @QueryProjection // 빌드하면 QUserSimpleDto가 생성되어 더 안전하게 조회 가능 (선택사항)
    public UserSimpleDto(Long id, Integer age) {
        this.id = id;
        this.age = age;
    }
}
