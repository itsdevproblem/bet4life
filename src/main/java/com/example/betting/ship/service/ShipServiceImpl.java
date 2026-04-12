package com.example.betting.ship.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.betting.ship.controller.ShipRequestDto;
import com.example.betting.ship.controller.port.ShipService;
import com.example.betting.ship.domain.Ship;
import com.example.betting.ship.service.port.ShipRepository;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

@Service
@Builder
@RequiredArgsConstructor
public class ShipServiceImpl implements ShipService {

    private final ShipRepository shipRepository;

    @Override
    public List<Ship> getAllSample() {
        return shipRepository.findAll();
    }

    @Override
    public List<Ship> select(String name) {
        return shipRepository.search(name);
    }

    @Override
    public Ship searchById(Long id) {
        return shipRepository.findById(id).orElseThrow();
    }

    @Override
    public Ship addSample(ShipRequestDto requestDto) {
        return shipRepository.save(
                Ship.builder()
                    .name(requestDto.getName())
                    .weight(requestDto.getWeight())
                    .build()
        );
    }

    @Override
    public Ship updateSample(ShipRequestDto requestDto) {
        Ship ss = shipRepository.findById(requestDto.getShipId()).orElseThrow();

        ss.updateName(requestDto.getName());

        return ss;
    }
    
}
