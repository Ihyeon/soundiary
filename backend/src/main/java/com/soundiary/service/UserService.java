package com.soundiary.service;

import com.soundiary.domain.User;
import com.soundiary.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper userMapper;

    public User getUser(Long id) {
        return userMapper.findById((id));
    }

    public Long registerUser(User user) {
        userMapper.insert(user);
        return user.getUserId();
    }
}
