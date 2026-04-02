package com.example.betting.jonghyeon.controller;

import com.example.betting.jonghyeon.entity.Sample;
import com.example.betting.jonghyeon.service.SampleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController("/jonghyeon")
@RequiredArgsConstructor
public class SampleController {

    private final SampleService sampleService;

    @GetMapping("/sample")
    public Map<String,Object> sample(){
        List<Sample> samples =  sampleService.getAllSample();

        Map<String, Object> result = new HashMap<>();
        result.put("result", samples);

        return result;
    }
}
