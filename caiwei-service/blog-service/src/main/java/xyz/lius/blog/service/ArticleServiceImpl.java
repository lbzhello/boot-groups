package xyz.lius.blog.service;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import xyz.lius.blog.api.ArticleService;
import xyz.lius.blog.mapper.ArticleMapper;
import xyz.lius.blog.model.Article;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public List<Article> findList() {
        return articleMapper.findList();
    }
}
