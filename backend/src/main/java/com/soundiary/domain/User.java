package com.soundiary.domain;

import lombok.Data;

import java.time.LocalDateTime;
import java.time.LocalDate;

@Data
public class User {
    private Long userId;
    private String password;
    private String nickname;
    private LocalDateTime createdAt;
    private String phoneNumber;
    private String address;
    private LocalDate birth;
    private String gender;
    private String email;
}
