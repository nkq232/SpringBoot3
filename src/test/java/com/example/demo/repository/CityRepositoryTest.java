package com.example.demo.repository;

import com.example.demo.entity.City;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class CityRepositoryTest {
    @Autowired
    private CityRepository cityRepository;

    private static boolean initialized = false;
    @Before
    public void setup() {
        if (!initialized) {
            //your db initialization
            City city1 = City.builder().cityName("Hanoi").cityCountryCode("VNC").build();
            City city2 = City.builder().cityName("Saigon").cityCountryCode("VN").build();
            cityRepository.save(city1);
            cityRepository.save(city2);
            initialized = true;
        }

    }
    @Test
    public void saveCity() {
        City city = City.builder().cityName("Hanoi").cityCountryCode("HN").build();
        City savedCity = cityRepository.save(city);
        Assertions.assertNotNull(savedCity);
        Assertions.assertEquals(savedCity.getCityName(), "Hanoi");
        Assertions.assertTrue(savedCity.getCityID() > 0);
    }

    @Test
    public void getAllCity() {
        List<City> cities = cityRepository.findAll();
        Assertions.assertNotNull(cities);
        Assertions.assertEquals(cities.size(), 2);
        Assertions.assertEquals(cities.get(0).getCityName(), "Hanoi");
    }

    @Test
    public void getCityById() {
        City city = cityRepository.findById(1).orElse(null);
        Assertions.assertNotNull(city);
        Assertions.assertEquals(city.getCityName(), "Hanoi");
        Assertions.assertEquals(city.getCityCountryCode(), "VNC");
    }
}
