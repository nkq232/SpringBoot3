package com.example.demo.service;

import com.example.demo.dto.CityDTO;
import com.example.demo.entity.City;

import java.util.List;

public interface CityService {
    List<CityDTO> findAll();
    CityDTO addCity(CityDTO dto);
    CityDTO findById(int id);
    CityDTO updateCity(CityDTO dto);
    String deleteCity(int id);
}
