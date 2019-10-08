package xyz.lius.user.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("xyz.lius.user.mapper")
public class MyBatisConfig {
}
