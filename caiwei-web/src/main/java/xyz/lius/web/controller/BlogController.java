package xyz.lius.web.controller;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.lius.blog.api.ArticleService;
import xyz.lius.blog.model.Article;

import java.util.List;

@RestController
@RequestMapping("/blog")
public class BlogController {
    @Reference
    private ArticleService articleService;

    @GetMapping("/articles")
    public List<Article> pageList() {
        return articleService.findList();
    }
}
