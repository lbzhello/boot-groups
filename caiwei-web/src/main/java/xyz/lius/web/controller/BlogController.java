package xyz.lius.web.controller;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.lius.blog.api.NewsService;
import xyz.lius.blog.model.News;

import java.util.List;

@RestController
@RequestMapping("/blogs")
public class BlogController {
    @Reference
    private NewsService newsService;

    @GetMapping("/news")
    public List<News> pageList() {
        return newsService.findList();
    }
}
