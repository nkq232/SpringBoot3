package com.example.demo.service.impl;

import com.example.demo.dto.CityDTO;
import com.example.demo.entity.City;
import com.example.demo.mapper.CityMapper;
import com.example.demo.repository.CityRepository;
import com.example.demo.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CityServiceImpl implements CityService {
    @Autowired
    private CityRepository cityRepository;
    @Override
    public List<CityDTO> findAll() {
        return CityMapper.toDTOList(cityRepository.findAll().stream().toList());
    }

    @Override
    public CityDTO addCity(CityDTO dto) {
        City city = CityMapper.toEntity(dto);
        cityRepository.save(city);
        return CityMapper.toDTO(city);
    }

    @Override
    public CityDTO findById(int id) {
        return CityMapper.toDTO(cityRepository.findById(id).orElse(null));
    }

    @Override
    public CityDTO updateCity(CityDTO dto) {
        City city = cityRepository.findById(dto.getCityID()).orElse(null);
        if(city == null) return null;
        city.setCityDistrict(dto.getCityDistrict());
        city.setCityName(dto.getCityName());
        city.setCityPopulation(dto.getCityPopulation());
        cityRepository.save(city);
        return CityMapper.toDTO(city);
    }

    @Override
    public String deleteCity(int id) {
        City city = cityRepository.findById(id).orElse(null);
        if(city == null) return "User not found";
        cityRepository.deleteById(id);
        return "Delete success";
    }
}
