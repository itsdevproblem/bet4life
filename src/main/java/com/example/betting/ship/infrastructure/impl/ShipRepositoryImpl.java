package com.example.betting.ship.infrastructure.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.betting.ship.domain.Ship;
import com.example.betting.ship.infrastructure.ShipJpaRepository;
import com.example.betting.ship.infrastructure.ShipRepositoryCustom;
import com.example.betting.ship.infrastructure.entity.ShipEntity;
import com.example.betting.ship.service.port.ShipRepository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ShipRepositoryImpl implements ShipRepository {

    private final ShipJpaRepository shipJpaRepository;
    private final ShipRepositoryCustom shipRepositoryCustom;

    @Override
    public List<Ship> findAll() {
        return shipJpaRepository.findAll().stream().map(ShipEntity::toModel).toList();
    }

    @Override
    public Optional<Ship> findById(Long id) {
        return shipJpaRepository.findById(id).map(ShipEntity::toModel);
    }

    @Override
    public Ship save(Ship ship) {
        return shipJpaRepository.save(ShipEntity.from(ship)).toModel();
    }

    @Override
    public Optional<Ship> findByUsrIdAndDelYn(String usrId, String delYn) {
        return shipJpaRepository.findByUsrIdAndDelYn(usrId, delYn).map(ShipEntity::toModel);
    }

    @Override
    public List<Ship> search(String name) {
        return shipRepositoryCustom.search(name).stream().map(ShipEntity::toModel).toList();
    }
    
}
