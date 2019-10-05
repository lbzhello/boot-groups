package xyz.lius.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.lius.web.entity.HelloWorld;
import xyz.lius.web.entity.User;
import xyz.lius.web.mapper.HelloWorldMapper;
import xyz.lius.web.mapper.UserMapper;

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

    @GetMapping("/{message}")
    public List<User> hello(@PathVariable("message") String message) {
        List<HelloWorld> helloWorlds = helloWorldMapper.findAll();
        List<User> users = userMapper.findAll();
        return users;
    }
}
