package com.example.betting.ship.infrastructure;

import java.util.List;

import com.example.betting.ship.infrastructure.entity.ShipEntity;

public interface ShipRepositoryCustom {
    List<ShipEntity> search(String name);
}
