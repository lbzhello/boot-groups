package xyz.lius.demo.spring.service.impl;

import xyz.lius.demo.spring.service.HelloWorld;

public class DefaultHelloWorld implements HelloWorld {
    private String message;

    public DefaultHelloWorld(String message) {
        this.message = message;
    }

    @Override
    public String sayHello() {
        System.out.println(message);
        return message;
    }
}
