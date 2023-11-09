package com.example.demo.service.impl;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import com.example.demo.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    private final UserUtil userUtil = new UserUtil();
    @Override
    public User findActiveUser(String username) {
        User user = this.userRepository.findById(username).orElse(null);
        return (user == null || !userUtil.checkActiveUserEntity(user)) ? null : user;
    }

    @Override
    public List<UserDTO> findAll() {
        return new UserMapper().toDTOs(this.userRepository.findAll());
    }

    @Override
    public List<UserDTO> findAllActive() {
        return new UserMapper().toDTOs(this.userRepository.findAll().stream().filter(s -> s.getActive() == 1).toList());
    }

    @Override
    public UserDTO addUser(UserDTO dto) {
        User user = this.userRepository.findById(dto.getUsername()).orElse(null);
        if (user != null) {
            return null;
        }
        UserMapper userMapper = new UserMapper();
        user = userMapper.toEntity(dto);
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        user.setId(userNum() + 1);
        this.userRepository.save(user);
        return UserMapper.toDTO(user);
    }

    @Override
    public int removeUser(String username) {
        User user = this.userRepository.findById(username).orElse(null);
        if (user == null || !userUtil.checkActiveUserEntity(user)) {
           return 0;
        }
        user.setActive(0);
        return 1;
    }

    int userNum() {
        return this.userRepository.findAll().size();
    }
}
