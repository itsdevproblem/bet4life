package com.example.betting.ship.controller;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.betting.mock.TestContainer;
import com.example.betting.ship.domain.Ship;

public class ShipControllerTest {
    
    private TestContainer testContainer;

    @BeforeEach
    void init() {
        testContainer = TestContainer.builder().build();
    }

    @Test
    void shipList를_조회할_수_있다() {
        // given
        testContainer.shipRepository.save(Ship.builder()
            .shipId(1L)
            .name("name1")
            .weight(1)
            .build());
        
        testContainer.shipRepository.save(Ship.builder()
            .shipId(2L)
            .name("name2")
            .weight(2)
            .build());
        
        // when
        Map<String,Object> result = testContainer.shipController.sample();

        // then
        List<Ship> data = (List<Ship>) result.get("result");
        assertThat(data.size()).isEqualTo(2);
        assertThat(data.get(0).getShipId()).isEqualTo(1);
        assertThat(data.get(0).getName()).isEqualTo("name1");
        assertThat(data.get(0).getWeight()).isEqualTo(1);
        assertThat(data.get(1).getShipId()).isEqualTo(2);
        assertThat(data.get(1).getName()).isEqualTo("name2");
        assertThat(data.get(1).getWeight()).isEqualTo(2);
    }
}
