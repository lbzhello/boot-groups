package xyz.lius.service.user.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("xyz.lius.service.user.mapper")
public class MyBatisConfig {
}
