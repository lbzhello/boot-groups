package xyz.lius.consumer.config;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@EnableDubbo(scanBasePackages = "xyz.lius.consumer.controller")
@PropertySource("dubbo-consumer.properties")
@ComponentScan("xyz.lius.consumer.controller")
public class ConsumerConfiguration {
}
