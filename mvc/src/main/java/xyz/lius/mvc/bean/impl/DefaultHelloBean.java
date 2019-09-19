package xyz.lius.mvc.bean.impl;

import xyz.lius.mvc.bean.HelloBean;

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
