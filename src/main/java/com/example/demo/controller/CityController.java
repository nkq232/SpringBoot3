package com.example.demo.controller;

import com.example.demo.dto.CityDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/city")
public class CityController {
    @Autowired
    private CityService cityService;


    @GetMapping("/")
    public ResponseEntity<List<CityDTO>> getAll() {
        return new ResponseEntity<>(cityService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<?> addCity(@RequestBody CityDTO cityDTO) throws Exception {
        CityDTO result = cityService.addCity(cityDTO);
        return result == null ? new ResponseEntity<>("Bad Request", HttpStatus.BAD_REQUEST)
                : new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{cityId}")
    public ResponseEntity<?> findById(@PathVariable int cityId) throws Exception {
        CityDTO result = cityService.findById(cityId);
        return result == null ? new ResponseEntity<>("City not found", HttpStatus.BAD_REQUEST)
                : new ResponseEntity<>(result, HttpStatus.OK);
    }
}
