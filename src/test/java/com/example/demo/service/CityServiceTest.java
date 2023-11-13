package com.example.demo.service;

import com.example.demo.dto.CityDTO;
import com.example.demo.entity.City;
import com.example.demo.mapper.CityMapper;
import com.example.demo.repository.CityRepository;
import com.example.demo.service.impl.CityServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CityServiceTest {
    @Mock
    private CityRepository cityRepository;

    @InjectMocks
    private CityServiceImpl cityService;

    @Test
    public void addCity() {
        City city = City.builder().cityCountryCode("AFG").cityName("Busal")
                .cityDistrict("Kabol").cityPopulation(123213)
                .build();
        CityDTO cityDTO = CityMapper.toDTO(city);
        when(cityRepository.save(Mockito.any(City.class))).thenReturn(city);
        CityDTO savedCity = cityService.addCity(cityDTO);
        Assertions.assertEquals(savedCity.getCityName(), city.getCityName());
        Assertions.assertNotNull(savedCity);
        verify(cityRepository.save(city));
    }

    @Test
    public void findAll() {
        City city = City.builder().cityCountryCode("AFG").cityName("Busal")
                .cityDistrict("Kabol").cityPopulation(123213)
                .build();
        when(cityRepository.findAll()).thenReturn(List.of(city));
        List<CityDTO> cities = this.cityService.findAll();
        Assertions.assertEquals(CityMapper.toDTOList(List.of(city)).get(0).getCityName(), cities.get(0).getCityName());
        verify(this.cityRepository).findAll();
    }

    @Test
    public void findById() {
        City city = City.builder().cityCountryCode("AFG").cityName("Busal")
                .cityDistrict("Kabol").cityID(2).cityPopulation(123213)
                .build();
        when(cityRepository.findById(anyInt())).thenReturn(Optional.of(city));
        CityDTO result = this.cityService.findById(2);
        Assertions.assertEquals(result.getCityName(), "Busal");
        verify(this.cityRepository).findById(2);
    }

    @Test
    public void updateCity() {
        City city = City.builder().cityCountryCode("AFG").cityName("Busal")
                .cityDistrict("Kabol").cityID(2).cityPopulation(123213)
                .build();
        CityDTO cityDTO = CityMapper.toDTO(city);

        when(cityRepository.findById(2)).thenReturn(Optional.ofNullable(city));
        when(cityRepository.save(Mockito.any(City.class))).thenReturn(city);
        CityDTO result = cityService.updateCity(cityDTO);
        Assertions.assertEquals(result.getCityName(), "Busal");
        verify(this.cityRepository).findById(2);
        verify(this.cityRepository).save(city);
    }

    @Test
    public void deleteCity() {
        City city = City.builder().cityCountryCode("AFG").cityName("Busal")
                .cityDistrict("Kabol").cityID(2).cityPopulation(123213)
                .build();
        when(cityRepository.findById(anyInt())).thenReturn(Optional.ofNullable(city));
        Assertions.assertAll(() -> cityService.deleteCity(2));
    }
}
