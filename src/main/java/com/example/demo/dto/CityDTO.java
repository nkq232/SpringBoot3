package com.example.demo.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
public class CityDTO {
    int cityID;
    private String cityName;
    private String cityCountryCode;
    private String cityDistrict;
    private long cityPopulation;

    public CityDTO(int cityID, String cityName, String cityCountryCode, String cityDistrict, long cityPopulation) {
        this.cityID = cityID;
        this.cityName = cityName;
        this.cityCountryCode = cityCountryCode;
        this.cityDistrict = cityDistrict;
        this.cityPopulation = cityPopulation;
    }
}
