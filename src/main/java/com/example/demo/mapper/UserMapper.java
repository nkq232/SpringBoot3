package com.example.demo.mapper;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.User;

import java.util.List;

public class UserMapper {
    public static UserDTO toDTO(User user) {
        return new UserDTO(user.getId(), user.getUsername(), user.getPassword(),
                user.getFirstName(), user.getLastName(), user.getEmail(),
                user.getActive(), new AuthorityMapper().toDTO(user.getAuthority()));
    }

    public List<UserDTO> toDTOs(List<User> users) {
        return users.stream().map(UserMapper::toDTO).toList();
    }
    public User toEntity(UserDTO dto) {
        return new User(dto.getUsername(), dto.getPassword(),
                dto.getFirstName(), dto.getLastName(), dto.getEmail(), dto.getActive(), new AuthorityMapper().toEntity(dto.getAuthorityDTO()));
    }
}
