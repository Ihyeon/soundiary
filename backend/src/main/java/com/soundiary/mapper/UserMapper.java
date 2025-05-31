package com.soundiary.mapper;

import com.soundiary.domain.User;

import java.util.List;

public interface UserMapper {
    /**
     * 사용자 ID로 사용자 정보 조회
     * @param id 조회할 사용자의 고유 ID
     * @return 해당 ID에 해당하는 사용자 객체, 없으면 null
     */
    User findById(Long id);
    /**
     * 회원가입
     * @param user 가입할 사용자 정보
     * @return insert된 행 수
     */
    Long insert(User user);
}
