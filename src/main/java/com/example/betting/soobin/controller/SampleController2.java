package com.example.betting.soobin.controller;

import com.example.betting.soobin.dto.SampleDTO;
import com.example.betting.soobin.entity.SampleSoobin;
import com.example.betting.soobin.service.SampleService2;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/soobin")
@RequiredArgsConstructor
public class SampleController2 {

    private final SampleService2 sampleService;

    @GetMapping("/sample")
    public Map<String,Object> sample(){
        List<SampleSoobin> samples =  sampleService.getAllSample();

        Map<String, Object> result = new HashMap<>();
        result.put("result", samples);

        return result;
    }


    @GetMapping("/queryDSL/select")
    public List<SampleSoobin> select(String name){
        List<SampleSoobin> d = sampleService.select(name);

        return d;
    }

    @PostMapping("/addSample")
    public Map<String,Object> addSample(@RequestBody SampleDTO sampleDTO){
        SampleSoobin ss = sampleService.save(sampleDTO.getName());


        Map<String, Object> result = new HashMap<>();
        result.put("result", ss == null ? "fail" : "success");

        return result;
    }
}
