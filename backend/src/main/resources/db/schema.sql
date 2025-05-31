CREATE TABLE GENRE (
                       GENRE_ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                       NAME VARCHAR(50) NOT NULL
);

CREATE TABLE ARTIST (
                        ARTIST_ID BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                        NAME VARCHAR(50) NOT NULL,
                        DEBUT_DATE DATE,
                        GENDER CHAR(1) CHECK (GENDER IN ('A', 'F', 'M')),
                        BIRTH DATE
);

CREATE TABLE MUSIC_ALBUM (
                             ALBUM_ID BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                             TITLE VARCHAR(100) NOT NULL,
                             RELEASE_DATE DATE,
                             THUMBNAIL_URL VARCHAR(255),
                             AVERAGE_RATING FLOAT,
                             ARTIST_ID BIGINT NOT NULL,
                             CREATED_AT DATETIME DEFAULT CURRENT_TIMESTAMP,
                             FOREIGN KEY (ARTIST_ID) REFERENCES ARTIST(ARTIST_ID)
);

CREATE TABLE USERS (
                       USER_ID BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                       PASSWORD VARCHAR(255) NOT NULL,
                       NICKNAME VARCHAR(50) NOT NULL,
                       CREATED_AT DATETIME DEFAULT CURRENT_TIMESTAMP,
                       PHONE_NUMBER VARCHAR(20),
                       ADDRESS VARCHAR(100),
                       BIRTH DATE,
                       GENDER CHAR(1) CHECK (GENDER IN ('A', 'F', 'M')),
                       EMAIL VARCHAR(255) NOT NULL
);

CREATE TABLE SEARCH_HISTORY (
                                SEARCH_ID BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                                KEYWORD VARCHAR(100) NOT NULL,
                                SEARCHED_AT DATETIME DEFAULT CURRENT_TIMESTAMP,
                                USER_ID BIGINT NOT NULL,
                                FOREIGN KEY (USER_ID) REFERENCES USERS(USER_ID)
);

CREATE TABLE MUSIC (
                       MUSIC_ID BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                       TITLE VARCHAR(100) NOT NULL,
                       YOUTUBE_URL VARCHAR(255),
                       AVERAGE_RATING FLOAT,
                       GENRE_ID INT NOT NULL,
                       ALBUM_ID BIGINT NOT NULL,
                       ARTIST_ID BIGINT NOT NULL,
                       FOREIGN KEY (GENRE_ID) REFERENCES GENRE(GENRE_ID),
                       FOREIGN KEY (ALBUM_ID) REFERENCES MUSIC_ALBUM(ALBUM_ID),
                       FOREIGN KEY (ARTIST_ID) REFERENCES ARTIST(ARTIST_ID)
);

CREATE TABLE REVIEW (
                        REVIEW_ID BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                        RATING FLOAT,
                        CONTENT TEXT,
                        CREATED_AT DATETIME DEFAULT CURRENT_TIMESTAMP,
                        USER_ID BIGINT NOT NULL,
                        MUSIC_ID BIGINT,
                        ALBUM_ID BIGINT,
                        FOREIGN KEY (USER_ID) REFERENCES USERS(USER_ID),
                        FOREIGN KEY (MUSIC_ID) REFERENCES MUSIC(MUSIC_ID),
                        FOREIGN KEY (ALBUM_ID) REFERENCES MUSIC_ALBUM(ALBUM_ID)
);

CREATE TABLE USER_LOG (
                          LOG_ID BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                          CLICKED_AT DATETIME DEFAULT CURRENT_TIMESTAMP,
                          MUSIC_ID BIGINT NOT NULL,
                          USER_ID BIGINT NOT NULL,
                          FOREIGN KEY (MUSIC_ID) REFERENCES MUSIC(MUSIC_ID),
                          FOREIGN KEY (USER_ID) REFERENCES USERS(USER_ID)
);

CREATE TABLE MUSIC_LIKE (
                            MUSIC_ID BIGINT NOT NULL,
                            USER_ID BIGINT NOT NULL,
                            LIKED_AT DATETIME DEFAULT CURRENT_TIMESTAMP,
                            PRIMARY KEY (MUSIC_ID, USER_ID),
                            FOREIGN KEY (MUSIC_ID) REFERENCES MUSIC(MUSIC_ID),
                            FOREIGN KEY (USER_ID) REFERENCES USERS(USER_ID)
);

CREATE TABLE RECOMMEND_RESULT (
                                  RECOMMEND_RESULT_ID BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY,
                                  SCORE FLOAT,
                                  GENERATED_AT DATETIME DEFAULT CURRENT_TIMESTAMP,
                                  USER_ID BIGINT NOT NULL,
                                  MUSIC_ID BIGINT NOT NULL,
                                  FOREIGN KEY (USER_ID) REFERENCES USERS(USER_ID),
                                  FOREIGN KEY (MUSIC_ID) REFERENCES MUSIC(MUSIC_ID)
);

CREATE TABLE PLAYLIST (
                          PLAYLIST_ID BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                          TITLE VARCHAR(100) NOT NULL,
                          CREATED_AT DATETIME DEFAULT CURRENT_TIMESTAMP,
                          USER_ID BIGINT NOT NULL,
                          FOREIGN KEY (USER_ID) REFERENCES USERS(USER_ID)
);

CREATE TABLE PLAYLIST_MUSIC (
                                PLAYLIST_ID BIGINT NOT NULL,
                                MUSIC_ID BIGINT NOT NULL,
                                PRIMARY KEY (PLAYLIST_ID, MUSIC_ID),
                                FOREIGN KEY (PLAYLIST_ID) REFERENCES PLAYLIST(PLAYLIST_ID),
                                FOREIGN KEY (MUSIC_ID) REFERENCES MUSIC(MUSIC_ID)
);
