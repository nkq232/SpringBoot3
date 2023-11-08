package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import com.example.demo.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    private final UserUtil userUtil = new UserUtil();
    @Override
    public User findWithUsername(String username) {
        User user = this.userRepository.findById(username).orElse(null);
        return (user == null || !userUtil.checkActiveUserEntity(user)) ? null : user;
    }


}
