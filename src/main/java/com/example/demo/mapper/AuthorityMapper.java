package com.example.demo.mapper;

import com.example.demo.dto.AuthorityDTO;
import com.example.demo.entity.Authority;

public class AuthorityMapper {
    Authority toEntity(AuthorityDTO dto) {
        return new Authority(dto.getId(), dto.getRole());
    }

    AuthorityDTO toDTO(Authority authority) {
        return new AuthorityDTO(authority.getId(), authority.getRole());
    }
}
