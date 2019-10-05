package xyz.lius.demo.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import xyz.lius.demo.spring.config.JavaConfig;
import xyz.lius.demo.spring.service.HelloWorld;


public class AnnotationApplication {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
        HelloWorld helloWorld = context.getBean(HelloWorld.class);
        helloWorld.sayHello();
    }
}
