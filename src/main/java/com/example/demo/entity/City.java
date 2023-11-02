package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="city")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int cityID;

    @Column(name = "Name")
    private String cityName;

    @Column(name = "District")
    private String cityDistrict;

    @Column(name = "Population")
    private long cityPopulation;
}
