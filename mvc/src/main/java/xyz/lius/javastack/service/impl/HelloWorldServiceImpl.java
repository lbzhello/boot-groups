package xyz.lius.javastack.service.impl;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.lius.javastack.entity.HelloWorld;
import xyz.lius.javastack.mapper.HelloWorldMapper;
import xyz.lius.javastack.service.HelloWorldService;

import java.util.List;

@Service
public class HelloWorldServiceImpl implements HelloWorldService {
    @Autowired
    private HelloWorldMapper helloWorldMapper;

    @Override
    public List<HelloWorld> findAll() {
        return helloWorldMapper.findAll();
    }

    @Override
    public HelloWorld findOne(String id) {
        return helloWorldMapper.findOne(id);
    }

    @Override
    public void insert(HelloWorld helloWorld) {
        helloWorldMapper.insert(helloWorld);
    }

    @Override
    public void update(HelloWorld helloWorld) {
        helloWorldMapper.update(helloWorld);
    }

    @Override
    public void delete(String id) {
        helloWorldMapper.delete(id);
    }
}
