package com.example.betting.ship.infrastructure.entity;

import com.example.betting.ship.domain.Ship;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "soobin_ship")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShipEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long shipId;

    private String name;
    private int weight;

    public Ship toModel() {
        return Ship.builder()
            .shipId(shipId)
            .name(name)
            .weight(weight)
            .build();
    }

    public static ShipEntity from(Ship ship) {
        return ShipEntity.builder()
            .shipId(ship.getShipId())
            .name(ship.getName())
            .weight(ship.getWeight())
            .build();
    }
}
