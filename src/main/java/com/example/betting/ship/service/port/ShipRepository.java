package com.example.betting.ship.service.port;

import java.util.List;
import java.util.Optional;

import com.example.betting.ship.domain.Ship;

public interface ShipRepository {
    List<Ship> findAll();
    Optional<Ship> findById(Long id);
    Ship save(Ship ship);
    Optional<Ship> findByNameAndWeight(String name, int weight);
    
    List<Ship> search(String name);
}
