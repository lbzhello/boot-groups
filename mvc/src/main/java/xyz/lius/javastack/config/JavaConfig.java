package xyz.lius.javastack.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.HandlerExceptionResolver;
import xyz.lius.javastack.bean.HelloBean;
import xyz.lius.javastack.bean.impl.DefaultHelloBean;

@Configuration
@ComponentScan("xyz.lius.javastack.bean")
@ComponentScan("xyz.lius.javastack.aop")
@EnableAspectJAutoProxy
public class JavaConfig {
    @Bean
    public HelloBean helloBean() {
        return new DefaultHelloBean("Hello Bean!");
    }

    @Bean
    public AppHandlerExceptionResolver appHandlerExceptionResolver() {
        return new AppHandlerExceptionResolver();
    }
    
}
