package com.example.betting.soobin.integration;

import com.example.betting.soobin.controller.SampleController2;
import com.example.betting.soobin.dto.SampleDTO;
import com.example.betting.soobin.entity.SampleSoobin;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
class IntegrationTest {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
        objectMapper = new ObjectMapper();
    }

    @Test
    void addSample_통합테스트() throws Exception {
        String json = """
        {
            "name": "수수수수빈"
        }
        """;
        SampleDTO dto = new SampleDTO();
        dto.setName("수수수수빈");
        mockMvc.perform(post("/soobin/addSample")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value("success"));
    }

    @Test
    void addSearchUpdateSample_통합테스트() throws Exception {

        SampleDTO dto = new SampleDTO();
        dto.setName("김뜌빈");

        mockMvc.perform(post("/soobin/addSample")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk());

        // search 한거 string 으로 result 가져오기
        String response = mockMvc.perform(get("/soobin/search")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        //string json to entity (이건 list임)
        List<SampleSoobin> list = objectMapper.readValue(
                response,
                objectMapper.getTypeFactory().constructCollectionType(List.class, SampleSoobin.class)
        );

        SampleSoobin ss = list.get(0);

        SampleDTO dto2 = new SampleDTO();
        dto2.setId(ss.getId());
        dto2.setName("이뜌빈");

        //update
        mockMvc.perform(post("/soobin/updateSample")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(dto2)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value("success"));

        // select by id
        String response2 = mockMvc.perform(get("/soobin/searchById?id="+dto2.getId())
                        .contentType("application/json"))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        SampleSoobin updated = objectMapper.readValue(response2,SampleSoobin.class);

        assertTrue(updated.getName().equals(dto2.getName()));
    }

    @Test
    void sample_전체조회_통합테스트() throws Exception {
        mockMvc.perform(get("/soobin/sample"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").isArray());
    }
}