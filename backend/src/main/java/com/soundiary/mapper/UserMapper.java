package com.soundiary.mapper;

import com.soundiary.domain.User;

import java.util.List;

public interface UserMapper {
    int insert(User user);
    User findById(Long id);
}
