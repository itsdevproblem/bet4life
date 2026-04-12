package com.example.betting.ship.controller;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import java.util.Map;
import java.util.Optional;

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
            .name("name1")
            .weight(1)
            .build());
            
            testContainer.shipRepository.save(Ship.builder()
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

    @Test
    void shipList를_이름으로_조회할_수_있다() {
        // given
        testContainer.shipRepository.save(Ship.builder()
            .name("name1")
            .weight(1)
            .build());
        
        ShipRequestDto requestDto = ShipRequestDto.builder()
            .name("name1")
            .build();
        
        // when
        List<Ship> d = testContainer.shipController.select(requestDto);

        // then
        assertThat(d.size()).isEqualTo(1);
        assertThat(d.get(0).getShipId()).isEqualTo(1);
        assertThat(d.get(0).getName()).isEqualTo("name1");
        assertThat(d.get(0).getWeight()).isEqualTo(1);
    }

    @Test
    void shipId로_ship을_조회할_수_있다() {
        // given
        testContainer.shipRepository.save(Ship.builder()
            .name("name1")
            .weight(1)
            .build());
        
        // when
        Ship ship = testContainer.shipController.searchById(1L);

        // then
        assertThat(ship.getShipId()).isEqualTo(1);
        assertThat(ship.getName()).isEqualTo("name1");
        assertThat(ship.getWeight()).isEqualTo(1);
    }

    @Test
    void ship을_저장할_수_있다() {
        // given
        ShipRequestDto requestDto = ShipRequestDto.builder()
            .name("name1")
            .weight(1)
            .build();
        
        // when
        Map<String, Object> result = testContainer.shipController.addSample(requestDto);

        // then
        assertThat(result.get("result")).isEqualTo("success");
        Optional<Ship> oShip = testContainer.shipRepository.findById(1L);
        assertThat(oShip.isPresent()).isEqualTo(true);
        Ship ship = oShip.get();
        assertThat(ship.getShipId()).isEqualTo(1);
        assertThat(ship.getName()).isEqualTo("name1");
        assertThat(ship.getWeight()).isEqualTo(1);
    }

    // @Test
    // void ship을_저장실패할_수_있다() {
    //     // given
    //     ShipRequestDto requestDto = ShipRequestDto.builder()
    //         .shipId(-1L)
    //         .build();
        
    //     // when
    //     Map<String, Object> result = testContainer.shipController.addSample(requestDto);

    //     // then
    //     assertThat(result.get("result")).isEqualTo("fail");
    // }

    @Test
    void ship을_수정할_수_있다() {
        // given
        testContainer.shipRepository.save(Ship.builder()
            .name("name1")
            .weight(1)
            .build());
        ShipRequestDto requestDto = ShipRequestDto.builder()
            .shipId(1L)
            .name("name2")
            .build();
        
        // when
        Map<String, Object> result = testContainer.shipController.updateSample(requestDto);

        // then
        assertThat(result.get("result")).isEqualTo("success");
    }
}
