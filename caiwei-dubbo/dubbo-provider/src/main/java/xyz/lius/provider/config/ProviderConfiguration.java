package xyz.lius.provider.config;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@EnableDubbo(scanBasePackages = "xyz.lius.provider.service")
@PropertySource("dubbo-provider.properties")
public class ProviderConfiguration {
}
