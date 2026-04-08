package com.example.betting.soobin.service;

import com.example.betting.soobin.dto.SampleDTO;
import com.example.betting.soobin.entity.SampleSoobin;
import com.example.betting.soobin.repository.SampleRepository2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SampleService2 {

    private final SampleRepository2 sampleRepository;

    public List<SampleSoobin> getAllSample() {
        return sampleRepository.findAll();
    }

    public List<SampleSoobin> select(String name){
        return sampleRepository.search(name);
    }

    public SampleSoobin selectById(Long id){
        return sampleRepository.findById(id).orElseThrow();
    }

    public SampleSoobin addSample(SampleDTO sampleDTO) {
        return sampleRepository.save(
                SampleSoobin.builder()
                        .name(sampleDTO.getName())
                        .build()
        );
    }

    @Transactional
    public SampleSoobin updateSample(SampleDTO sampleDTO) {
        SampleSoobin ss = sampleRepository.findById(sampleDTO.getId()).orElseThrow();

        ss.setName(sampleDTO.getName());

        return ss;
    }
}
