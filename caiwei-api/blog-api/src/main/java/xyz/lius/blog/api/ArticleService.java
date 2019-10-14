package xyz.lius.blog.api;

import xyz.lius.blog.model.Article;

import java.util.List;

public interface ArticleService {
    List<Article> findList();
}
