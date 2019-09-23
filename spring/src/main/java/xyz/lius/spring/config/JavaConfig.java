package xyz.lius.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import xyz.lius.spring.service.HelloWorld;
import xyz.lius.spring.service.impl.DefaultHelloWorld;

@Configuration
@ComponentScan("xyz.lius.spring.bean")
@ComponentScan("xyz.lius.spring.aop")
@EnableAspectJAutoProxy
public class JavaConfig {
    @Bean
    public HelloWorld helloBean() {
        return new DefaultHelloWorld("Hello World!");
    }
}
