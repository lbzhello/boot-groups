package xyz.lius.demo.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import xyz.lius.demo.spring.service.HelloWorld;
import xyz.lius.demo.spring.service.impl.DefaultHelloWorld;

@Configuration
@ComponentScan("xyz.lius.demo.spring.bean")
@ComponentScan("xyz.lius.demo.spring.aop")
@EnableAspectJAutoProxy
public class JavaConfig {
    @Bean
    public HelloWorld helloBean() {
        return new DefaultHelloWorld("Hello World!");
    }
}
