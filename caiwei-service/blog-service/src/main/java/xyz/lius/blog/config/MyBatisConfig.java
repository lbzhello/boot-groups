package xyz.lius.blog.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("xyz.lius.blog.mapper")
public class MyBatisConfig {
}
