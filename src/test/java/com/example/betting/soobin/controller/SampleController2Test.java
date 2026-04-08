package com.example.betting.soobin.controller;


import com.example.betting.soobin.dto.SampleDTO;
import com.example.betting.soobin.entity.SampleSoobin;
import com.example.betting.soobin.service.SampleService2;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class SampleController2Test {

    @Mock
    private SampleService2 sampleService;

    @InjectMocks
    private SampleController2 sampleController;

    private MockMvc mockMvc;
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(sampleController).build();
        objectMapper = new ObjectMapper();
    }


    @Test
    void sample_조회_성공() throws Exception {
        when(sampleService.getAllSample()).thenReturn(List.of(new SampleSoobin()));

        mockMvc.perform(get("/soobin/sample"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").isArray());
    }


    @Test
    void search_조회_성공() throws Exception {
        SampleDTO dto = new SampleDTO();
        dto.setName("이수빈2");

        when(sampleService.select("이수빈2")).thenReturn(List.of(new SampleSoobin()));

        mockMvc.perform(get("/soobin/search")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk());
    }


    @Test
    void addSample_성공() throws Exception {
        SampleDTO dto = new SampleDTO();
        dto.setName("이뜌빈");

        when(sampleService.addSample(any())).thenReturn(new SampleSoobin());

        mockMvc.perform(post("/soobin/addSample")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value("success"));
    }


    @Test
    void addSample_실패() throws Exception {
        SampleDTO dto = new SampleDTO();
        dto.setName("이뜌빈");



        when(sampleService.addSample(any())).thenReturn(null); // 만약 null 을 return 한다면

        mockMvc.perform(post("/soobin/addSample")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value("fail"));
    }

    @Test
    void updateSample_성공() throws Exception {
        SampleDTO dto = new SampleDTO();
        dto.setId(1L);
        dto.setName("뜌빈테스트");

        when(sampleService.updateSample(any())).thenReturn(new SampleSoobin());

        mockMvc.perform(post("/soobin/updateSample")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value("success"));
    }


    @Test
    void updateSample_실패() throws Exception {
        SampleDTO dto = new SampleDTO();
        dto.setId(1L);
        dto.setName("뜌빈테스트");

        when(sampleService.updateSample(any())).thenReturn(null);

        mockMvc.perform(post("/soobin/updateSample")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value("fail"));
    }
}