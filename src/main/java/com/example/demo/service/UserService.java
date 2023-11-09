package com.example.demo.service;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.User;

import java.util.List;


public interface UserService {
    User findActiveUser(String username);
    int removeUser(String username);

    UserDTO addUser(UserDTO dto);
    List<UserDTO> findAllActive();

    List<UserDTO> findAll();


}
