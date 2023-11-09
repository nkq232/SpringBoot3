package com.example.demo.service;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.List;


public interface UserService {
    User findActiveUser(String username);
    List<UserDTO> findAllActive();
    List<UserDTO> findAll();
    UserDTO addUser(UserDTO dto);
    UserDTO updateUser(ObjectNode objectNode) throws JsonProcessingException;
    String removeUser(String username);


}
