package xyz.lius.javastack.controller;

import org.apache.ibatis.jdbc.SQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.lius.javastack.entity.HelloWorld;
import xyz.lius.javastack.entity.User;
import xyz.lius.javastack.mapper.HelloWorldMapper;
import xyz.lius.javastack.mapper.UserMapper;

import java.util.List;

@RestController
@RequestMapping("/hello")
public class HelloWorldController {
    @Autowired
    private HelloWorldMapper helloWorldMapper;

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/test")
    public ResponseEntity<String> test() throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        ResponseEntity<String> entity = new ResponseEntity<String>("hhhh", headers, HttpStatus.OK);

        throw new Exception("未知请求！");
    }

    @RequestMapping("/{message}")
    public String hello(@PathVariable("message") String message) {
//        List<HelloWorld> helloWorlds = helloWorldMapper.findAll();
//        List<User> users = userMapper.findAll();
//        new SQL(){};
        return "hello" + message;
    }
}
