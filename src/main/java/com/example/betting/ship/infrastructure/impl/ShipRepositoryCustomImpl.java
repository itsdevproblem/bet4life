package com.example.betting.ship.infrastructure.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.betting.ship.infrastructure.ShipRepositoryCustom;
import com.example.betting.ship.infrastructure.entity.QShipEntity;
import com.example.betting.ship.infrastructure.entity.ShipEntity;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class ShipRepositoryCustomImpl implements ShipRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public ShipRepositoryCustomImpl(JPAQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }

    @Override
    public List<ShipEntity> search(String name) {
        System.out.println(name);
        QShipEntity ship = QShipEntity.shipEntity;
        return queryFactory
                .selectFrom(ship)
                .where(
                        nameEq(name)
                )
                .orderBy(ship.shipId.desc())
                .limit(10)
                .fetch();
    }

    private BooleanExpression nameEq(String name) {
        return name != null ? QShipEntity.shipEntity.name.eq(name) : null;
    }
    
}
