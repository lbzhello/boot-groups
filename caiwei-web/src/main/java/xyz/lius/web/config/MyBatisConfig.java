package xyz.lius.web.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("xyz.lius.web.mapper")
public class MyBatisConfig {
}
