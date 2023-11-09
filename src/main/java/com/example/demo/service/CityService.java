package com.example.demo.service;

import com.example.demo.dto.CityDTO;
import com.example.demo.entity.City;

import java.util.List;

public interface CityService {
    List<CityDTO> findAll();
}
