package xyz.lius.javastack.bean.impl;

import xyz.lius.javastack.bean.HelloBean;

public class DefaultHelloBean implements HelloBean {
    private String message;

    public DefaultHelloBean(String message) {
        this.message = message;
    }

    @Override
    public String sayHello() {
        System.out.println(message);
        return message;
    }
}
