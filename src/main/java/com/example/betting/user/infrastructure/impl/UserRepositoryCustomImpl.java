package com.example.betting.user.infrastructure.impl;


import java.util.List;

import com.example.betting.user.dto.UserSimpleDto;
import com.example.betting.user.infrastructure.UserRepositoryCustom;
import com.example.betting.user.infrastructure.entity.QUserEntity;
import com.example.betting.user.infrastructure.entity.UserEntity;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserRepositoryCustomImpl implements UserRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public List<UserEntity> searchUsers(String name, Integer age) {

        QUserEntity user = QUserEntity.userEntity;
        return queryFactory
                .selectFrom(user) //
                .where(
                    usernameEq(name),
                    ageEq(age),
                    user.username.eq(name),
                    user.age.goe(age) // 나이가 age 이상
                )
                .orderBy(user.username.asc())
                .fetch();
    }

    // Null 체크를 통한 동적 쿼리 조건 (where 절에서 쉼표는 AND 조건)
    private BooleanExpression usernameEq(String username) {
        return username != null ? QUserEntity.userEntity.username.eq(username) : null;
    }

    private BooleanExpression ageEq(Integer age) {
        return age != null ? QUserEntity.userEntity.age.eq(age) : null;
    }

    public List<Tuple> searchUsers1(String name, Integer age) {

        QUserEntity user = QUserEntity.userEntity;
        return queryFactory
                .select(user.id, user.age)
                .from(user)
                .where(
                    usernameEq(name),
                    ageEq(age),
                    user.username.eq(name),
                    user.age.goe(age) // 나이가 age 이상
                )
                .orderBy(user.username.asc())
                .fetch();
    }

    public List<UserSimpleDto> searchUsers2(String name, Integer age) {

        QUserEntity user = QUserEntity.userEntity;
        return queryFactory
                .select(Projections.fields(UserSimpleDto.class,
                    user.id,
                    user.age
                ))
                .from(user)
                .where(
                    usernameEq(name),
                    ageEq(age),
                    user.username.eq(name),
                    user.age.goe(age) // 나이가 age 이상
                )
                .orderBy(user.username.asc())
                .fetch();
    }

    public List<Long> searchUsers3(String name, Integer age) {
        QUserEntity user = QUserEntity.userEntity;
        return queryFactory
                .select(user.id)
                .from(user)
                .where(
                    usernameEq(name),
                    ageEq(age),
                    user.username.eq(name),
                    user.age.goe(age) // 나이가 age 이상
                )
                .orderBy(user.username.asc())
                .fetch();
    }
}
