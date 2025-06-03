package com.soundiary.mapper;

import com.soundiary.domain.User;

import java.util.List;

public interface UserMapper {
    /**
     * 사용자 이메일로 사용자 정보 조회
     * @param email 조회할 사용자의 고유 이메일
     * @return 해당 email 에 해당하는 사용자 객체, 없으면 null
     */
    User findByEmail(String email);
    /**
     * 회원가입
     * @param user 가입할 사용자 정보
     * @return insert된 행 수
     */
    int insert(User user);
}
