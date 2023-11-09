package com.example.demo.service.impl;

import com.example.demo.dto.CityDTO;
import com.example.demo.mapper.CityMapper;
import com.example.demo.repository.CityRepository;
import com.example.demo.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {
    @Autowired
    private CityRepository cityRepository;
    @Override
    public List<CityDTO> findAll() {
        return CityMapper.toDTOList(cityRepository.findAll().stream().toList());
    }
}
