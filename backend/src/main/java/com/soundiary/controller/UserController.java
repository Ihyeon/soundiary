package com.soundiary.controller;

import com.soundiary.domain.User;
import com.soundiary.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    /**
     * 이메일 중복 확인 API
     * @param email 가입할 이메일
     * @return true: 중복됨 / false: 사용 가능
     */
    @GetMapping("/check-email")
    public ResponseEntity<Boolean> checkEmailDuplicate(@RequestParam String email) {
        return ResponseEntity.ok(userService.isEmailDuplicated(email));
    }

    /**
     * 회원가입 API
     * @param user 회원 정보
     * @return 생성된 사용자 ID
     */
    @PostMapping
    public ResponseEntity<Long> registerUser(@RequestBody User user) {
        Long userId = userService.registerUser(user);
        return ResponseEntity.ok(userId);
    }


}
