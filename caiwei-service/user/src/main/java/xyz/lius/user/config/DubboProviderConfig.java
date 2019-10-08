package xyz.lius.user.config;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableDubbo(scanBasePackages = "xyz.lius.user.service")
public class DubboProviderConfig {
}
