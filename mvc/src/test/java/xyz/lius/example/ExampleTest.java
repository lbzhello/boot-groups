package xyz.lius.example;

import org.junit.Test;
import xyz.lius.example.proxy.JdkDynamicProxy;
import xyz.lius.javastack.bean.HelloBean;
import xyz.lius.javastack.bean.impl.DefaultHelloBean;

public class ExampleTest {
    @Test
    public void proxyTest() {
        HelloBean helloBean = new JdkDynamicProxy<HelloBean>(
                new DefaultHelloBean("hello bean")).getProxy();
        helloBean.sayHello();
    }
}
