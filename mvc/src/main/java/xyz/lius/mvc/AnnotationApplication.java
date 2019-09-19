package xyz.lius.mvc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import xyz.lius.mvc.bean.HelloBean;
import xyz.lius.mvc.config.JavaConfig;


public class AnnotationApplication {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
        HelloBean helloBean = context.getBean(HelloBean.class);
        helloBean.sayHello();
    }
}
