package com.example.betting.jonghyeon.service;

import com.example.betting.jonghyeon.entity.Sample;
import com.example.betting.jonghyeon.repository.SampleRepository;
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
