package com.example.betting.ship.controller;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ShipRequestDto {
    
    private Long shipId;
    private String name;
    private int weight;
}
