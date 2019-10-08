package xyz.lius.web.controller;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.lius.user.User;
import xyz.lius.user.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Reference
    private UserService userService;

    @GetMapping
    public List<User> pageList() {
        List<User> users = userService.findList();
        return users;
    }

    @GetMapping("/{id}")
    public User get(@PathVariable("id") int id) {
        return userService.findById(id);
    }
}
