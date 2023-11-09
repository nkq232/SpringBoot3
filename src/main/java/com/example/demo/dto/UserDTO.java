package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class UserDTO {
    private int id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private int active;
    private AuthorityDTO authorityDTO;
}
