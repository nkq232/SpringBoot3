package com.example.demo.mapper;

import com.example.demo.dto.CityDTO;
import com.example.demo.entity.City;

import java.util.List;
import java.util.stream.Collectors;

public class CityMapper {

    public static City toEntity(CityDTO dto) {
        return new City(dto.getCityID(), dto.getCityName(), dto.getCityCountryCode()
                , dto.getCityDistrict(), dto.getCityPopulation());
    }

    public static CityDTO toDTO(City entity) {
        return new CityDTO(entity.getCityID(), entity.getCityName(), entity.getCityCountryCode()
                , entity.getCityDistrict(), entity.getCityPopulation());
    }

    public static List<CityDTO> toDTOList(List<City> entities) {
        return entities.stream().map(CityMapper::toDTO).toList();
    }

    public static List<City> toEntityList(List<CityDTO> dto) {
        return dto.stream().map(CityMapper::toEntity).toList();
    }
}
