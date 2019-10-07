package xyz.lius.web.config;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@EnableDubbo(scanBasePackages = "xyz.lius.web.controller")
@ComponentScan("xyz.lius.web.controller")
public class DubboConsumerConfig {
}
