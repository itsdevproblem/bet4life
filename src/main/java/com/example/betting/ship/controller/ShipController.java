package com.example.betting.ship.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.betting.ship.controller.port.ShipService;
import com.example.betting.ship.domain.Ship;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/ship")
@RequiredArgsConstructor
public class ShipController {
    
    private final ShipService shipService;

    @GetMapping("/sample")
    public Map<String,Object> sample() {
        List<Ship> data = shipService.getAllSample();
        
        Map<String, Object> result = new HashMap<>();
        result.put("result", data);

        return result;
    }

    @GetMapping("/search")
    public List<Ship> select(@RequestBody ShipRequestDto requestDto) {
        List<Ship> d = shipService.select(requestDto.getName());
        
        return d;
    }

    @GetMapping("/searchById")
    public Ship searchById(@RequestParam Long id) {
        return shipService.searchById(id);
    }

    @PostMapping("/addSample")
    public Map<String,Object> addSample(@RequestBody ShipRequestDto requestDto){
        Ship ss = shipService.addSample(requestDto);

        Map<String, Object> result = new HashMap<>();
        result.put("result", ss == null ? "fail" : "success");

        return result;
    }

    @PostMapping("/updateSample")
    public Map<String, Object> updateSample(@RequestBody ShipRequestDto requestDto){
        Ship ss = shipService.updateSample(requestDto);

        Map<String, Object> result = new HashMap<>();
        result.put("result", ss == null ? "fail" : "success");

        return result;
    }
}
