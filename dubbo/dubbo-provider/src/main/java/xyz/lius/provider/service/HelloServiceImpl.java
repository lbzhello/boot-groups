package xyz.lius.provider.service;

import org.apache.dubbo.config.annotation.Service;
import xyz.lius.api.service.HelloService;

@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public String say(String message) {
        return message;
    }
}
