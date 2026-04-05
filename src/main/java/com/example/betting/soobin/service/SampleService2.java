package com.example.betting.soobin.service;

import com.example.betting.soobin.entity.SampleSoobin;
import com.example.betting.soobin.repository.SampleRepository2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SampleService2 {

    private final SampleRepository2 sampleRepository;

    public List<SampleSoobin> getAllSample() {
        return sampleRepository.findAll();
    }
}
