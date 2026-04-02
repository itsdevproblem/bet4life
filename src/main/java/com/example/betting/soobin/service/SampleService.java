package com.example.betting.soobin.service;

import com.example.betting.soobin.entity.Sample;
import com.example.betting.soobin.repository.SampleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SampleService {

    private final SampleRepository sampleRepository;

    public List<Sample> getAllSample() {
        return sampleRepository.findAll();
    }
}
