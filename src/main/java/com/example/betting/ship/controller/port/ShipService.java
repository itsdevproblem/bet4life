package com.example.betting.ship.controller.port;

import java.util.List;

import com.example.betting.ship.controller.ShipRequestDto;
import com.example.betting.ship.domain.Ship;

public interface ShipService {

    List<Ship> getAllSample();

    List<Ship> select(String name);

    Ship searchById(Long id);

    Ship addSample(ShipRequestDto requestDto);

    Ship updateSample(ShipRequestDto requestDto);
    
}
