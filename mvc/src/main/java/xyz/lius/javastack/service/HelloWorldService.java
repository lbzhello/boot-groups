package xyz.lius.javastack.service;

import xyz.lius.javastack.entity.HelloWorld;

import java.util.List;

public interface HelloWorldService {
    List<HelloWorld> findAll();

    HelloWorld findOne(String id);

    void insert(HelloWorld helloWorld);

    void update(HelloWorld helloWorld);

    void delete(String id);
}
