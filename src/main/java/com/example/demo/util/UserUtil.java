package com.example.demo.util;

import com.example.demo.entity.User;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserUtil {
    public boolean checkActiveUserEntity(User user) {
        return user.getActive() != 0;
    }
}
