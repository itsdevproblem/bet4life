package com.example.betting.ship.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Ship {
    
    private Long shipId;
    private String name;
    private int weight;

    public void updateName(String name) {
        this.name = name;
    }
}
