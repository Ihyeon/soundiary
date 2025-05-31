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

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUser(id));
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
