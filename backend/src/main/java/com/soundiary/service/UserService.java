package com.soundiary.service;

import com.soundiary.domain.User;
import com.soundiary.exception.DuplicateEmailException;
import com.soundiary.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper userMapper;

    /**
     * 이메일 중복 여부 확인
     * @param email 확인할 이메일
     * @return true: 중복된 이메일 / false: 사용 가능
     */
    public boolean isEmailDuplicated(String email) {
        return userMapper.findByEmail(email) != null;
    }

    // 회원가입 처리 후 userId 반환

    /**
     * 회원 가입
     * @param user 회원가입할 사용자 정보
     * @return 생성된 사용자의 userId
     */
    public Long registerUser(User user) {

        // 이메일 중복 검사
        if (userMapper.findByEmail(user.getEmail()) != null) {
            throw new DuplicateEmailException("이메일 중복");
        }

        int result = userMapper.insert(user);
        if (result != 1) {
            throw new RuntimeException("회원가입 실패");
        }
        return user.getUserId();
    }
}
