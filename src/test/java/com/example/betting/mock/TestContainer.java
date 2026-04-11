package com.example.betting.mock;

import com.example.betting.ship.controller.ShipController;
import com.example.betting.ship.controller.port.ShipService;
import com.example.betting.ship.service.ShipServiceImpl;
import com.example.betting.ship.service.port.ShipRepository;

import lombok.Builder;

public class TestContainer {
    
    public final ShipRepository shipRepository;

    public final ShipService shipService;

    public final ShipController shipController;

    @Builder
    public TestContainer() {
        this.shipRepository = new FakeShipRepository();

        this.shipService = ShipServiceImpl.builder()
            .shipRepository(shipRepository)
            .build();

        this.shipController = ShipController.builder()
            .shipService(shipService)
            .build();
    }
}
