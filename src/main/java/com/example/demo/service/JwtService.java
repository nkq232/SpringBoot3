package com.example.demo.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService {
    public String generateToken(String username);
    public Boolean validateToken(String token, UserDetails userDetails);
    public String extractUsername(String token);
}
