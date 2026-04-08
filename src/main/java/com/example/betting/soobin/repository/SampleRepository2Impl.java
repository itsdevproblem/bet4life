package com.example.betting.soobin.repository;

import com.example.betting.soobin.entity.QSampleSoobin;
import com.example.betting.soobin.entity.SampleSoobin;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;

import java.util.List;

public class SampleRepository2Impl implements SampleRepositoryCustom2{
    private final JPAQueryFactory queryFactory;

    public SampleRepository2Impl(JPAQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }

    @Override
    public List<SampleSoobin> search(String name) {
        System.out.println(name);
        QSampleSoobin sample = QSampleSoobin.sampleSoobin;
        return queryFactory
                .selectFrom(sample)
                .where(
                        nameEq(name)
                )
                .orderBy(sample.id.desc())
                .limit(10)
                .fetch();
    }

    private BooleanExpression nameEq(String name) {
        return name != null ? QSampleSoobin.sampleSoobin.name.eq(name) : null;
    }
}
