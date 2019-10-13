package xyz.lius.blog.mapper;

import xyz.lius.blog.model.News;

import java.util.List;

public interface NewsMapper {
    List<News> findList();
}
