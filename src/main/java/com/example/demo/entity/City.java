package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Builder
@Table(name="city")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int cityID;

    @Column(name = "Name")
    private String cityName;

    @Column(name = "CountryCode")
    private String cityCountryCode;

    @Column(name = "District")
    private String cityDistrict;

    @Column(name = "Population")
    private long cityPopulation;

    public City(int cityID, String cityName, String cityCountryCode, String cityDistrict, long cityPopulation) {
        this.cityID = cityID;
        this.cityName = cityName;
        this.cityCountryCode = cityCountryCode;
        this.cityDistrict = cityDistrict;
        this.cityPopulation = cityPopulation;
    }
}
