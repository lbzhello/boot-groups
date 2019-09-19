package xyz.lius.mvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import xyz.lius.mvc.bean.HelloBean;
import xyz.lius.mvc.bean.impl.DefaultHelloBean;

@Configuration
@ComponentScan("xyz.lius.mvc.bean")
@ComponentScan("xyz.lius.mvc.aop")
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
