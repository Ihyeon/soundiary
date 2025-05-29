package com.soundiary.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@MapperScan("com.soundiary.mapper")
public class MyBatisConfig {

}
