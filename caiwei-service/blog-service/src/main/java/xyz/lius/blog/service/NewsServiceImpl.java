package xyz.lius.blog.service;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import xyz.lius.blog.api.NewsService;
import xyz.lius.blog.mapper.NewsMapper;
import xyz.lius.blog.model.News;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    private NewsMapper newsMapper;

    @Override
    public List<News> findList() {
        return newsMapper.findList();
    }
}
