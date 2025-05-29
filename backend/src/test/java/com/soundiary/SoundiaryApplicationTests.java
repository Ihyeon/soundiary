package com.soundiary;

import com.soundiary.domain.User;
import com.soundiary.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SoundiaryApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testInsert() {
        User user = new User();
        user.setPassword("0000");
        user.setNickname("IH");
        user.setPhoneNumber("010-1234-5678");
        user.setAddress("서울시");
        user.setBirth(LocalDate.of(1992, 11, 9));
        user.setGender("F");
        user.setEmail("IH@email.com");

        int rows = userMapper.insert(user);
        System.out.println("insert 결과: " + rows);
        assertEquals(1, rows);
    }

    @Test
    public void testFindById() {
        // given
        Long id = 1L;

        // when
        User user = userMapper.findById(id);

        // then
        System.out.println("조회된 사용자: " + user);
        assertNotNull(user);
    }

}
