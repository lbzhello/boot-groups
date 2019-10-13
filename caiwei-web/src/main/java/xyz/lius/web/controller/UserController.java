package xyz.lius.web.controller;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;
import xyz.lius.user.model.User;
import xyz.lius.user.api.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
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
