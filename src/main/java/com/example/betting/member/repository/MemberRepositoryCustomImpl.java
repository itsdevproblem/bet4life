package com.example.betting.member.repository;

import static com.example.betting.member.vo.QMember.member;

import java.util.List;

import com.example.betting.member.vo.Member;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class MemberRepositoryCustomImpl implements MemberRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Member> search(String username, Integer age) {
        return queryFactory
                .selectFrom(member)
                .where(
                    usernameEq(username),
                    ageEq(age)
                )
                .fetch();
    }

    private BooleanExpression usernameEq(String username) {
        return username != null ? member.username.eq(username) : null;
    }

    private BooleanExpression ageEq(Integer age) {
        return age != null ? member.age.eq(age) : null;
    }
}
