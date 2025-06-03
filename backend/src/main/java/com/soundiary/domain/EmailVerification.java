package com.soundiary.domain;

import java.time.LocalDateTime;

public class EmailVerification {
    private Long verificationId;
    private String email;
    private String token;
    private LocalDateTime created_at;
    private String verified;
}
