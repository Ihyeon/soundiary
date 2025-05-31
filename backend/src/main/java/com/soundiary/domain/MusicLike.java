package com.soundiary.domain;

import java.time.LocalDateTime;

public class MusicLike {
    private Long musicId; // PK + FK
    private Long userId; // PK + FK
    private LocalDateTime likedAt;
}
