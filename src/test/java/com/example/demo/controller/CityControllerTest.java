package com.example.demo.controller;

import com.example.demo.dto.CityDTO;
import com.example.demo.entity.City;
import com.example.demo.mapper.CityMapper;
import com.example.demo.service.CityService;
import com.example.demo.service.JwtService;
import com.example.demo.service.impl.AuthService;
import com.example.demo.service.impl.CityServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@WebMvcTest(controllers = CityController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
public class CityControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private CityService cityService;
    @MockBean
    private JwtService jwtService;

    @MockBean
    private AuthService authService;
    @Autowired
    private ObjectMapper objectMapper;

    private City city;
    private CityDTO cityDTO;
    @BeforeEach
    public void init() {
        city = City.builder().cityName("Hanoi").cityPopulation(123300)
                .cityCountryCode("VN").cityDistrict("PVD")
                .cityID(1).build();
        cityDTO = CityMapper.toDTO(city);
    }
    @Test
    public void addCity() throws Exception {
        given(cityService.addCity(ArgumentMatchers.any())).willAnswer(invocation -> invocation.getArgument(0));
        ResultActions response = mockMvc.perform(post("/city/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(cityDTO)));
        response.andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andExpect(MockMvcResultMatchers.jsonPath("$.cityName"
                        , CoreMatchers.is(cityDTO.getCityName())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.cityDistrict"
                        , CoreMatchers.is(cityDTO.getCityDistrict())));
    }

    @Test
    public void findAllCity() throws Exception {
        when(cityService.findAll()).thenReturn(List.of(cityDTO));
        ResultActions response = mockMvc.perform(get("/city/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(cityDTO)));
        response.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].cityName"
                        , CoreMatchers.is(cityDTO.getCityName())));
    }

    @Test
    public void getCityById() throws Exception {
        int cityId = 1;
        when(cityService.findById(cityId)).thenReturn(cityDTO);
        ResultActions response = mockMvc.perform(get("/city/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(cityDTO)));
        response.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.cityName", CoreMatchers.is(cityDTO.getCityName())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.cityDistrict", CoreMatchers.is(cityDTO.getCityDistrict())));
    }
}
