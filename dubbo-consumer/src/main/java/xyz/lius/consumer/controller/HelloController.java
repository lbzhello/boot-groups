package xyz.lius.consumer.controller;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.lius.api.service.HelloService;

@RestController
@RequestMapping("/hello")
public class HelloController {
    @Reference
    private HelloService helloService;

    @GetMapping("/{message}")
    public String hello(@PathVariable("message") String message) {
        return helloService.say(message);
    }
}
