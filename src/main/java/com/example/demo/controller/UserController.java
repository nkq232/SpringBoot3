package com.example.demo.controller;

import com.example.demo.dto.UserDTO;
import com.example.demo.service.UserService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public ResponseEntity<List<UserDTO>> getAll() {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/active")
    public ResponseEntity<List<UserDTO>> getAllActive() {
        return new ResponseEntity<>(userService.findAllActive(), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<?> addUser(@RequestBody UserDTO userDTO) throws Exception {
        UserDTO result = userService.addUser(userDTO);
        return result == null ? new ResponseEntity<>("Bad Request", HttpStatus.BAD_REQUEST)
        : new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<?> updateUser(@RequestBody ObjectNode objectNode) throws Exception {
        UserDTO result = userService.updateUser(objectNode);
        return result == null ? new ResponseEntity<>("Bad Request", HttpStatus.BAD_REQUEST)
                : new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<String> deleteUser(@PathVariable String username) throws Exception {
        String result = userService.removeUser(username);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
