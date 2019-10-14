package xyz.lius.blog.mapper;

import xyz.lius.blog.model.Article;

import java.util.List;

public interface ArticleMapper {
    List<Article> findList();
}
