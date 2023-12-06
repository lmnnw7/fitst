package com.lh.service.impl;

import com.lh.mapper.DeviceMapper;
import com.lh.mapper.NewsMapper;
import com.lh.pojo.News;
import com.lh.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;


@Service//服务类，优先使用
@Primary
public class NewsServiceImpl implements NewsService {

    @Autowired(required = false)
    private NewsMapper newsMapper;

    @Override
    public News findNewsByID(Integer id) {
        return newsMapper.findNewsByID(id);
    }

    @Override
    public int deleteNewsByID(Integer id) {
        return newsMapper.deleteNewsByID(id);
    }

    @Override
    public int updateNews(News news) {
        return newsMapper.updateNews(news);
    }

    @Override
    public List<News> findNewsByStr(String searchStr) {
        return newsMapper.findNewsByStr(searchStr);
    }

    @Override
    public List<News> findAllNews() {
        return newsMapper.findAllNews();
    }

    @Override
    public int insertNews(News news) {
        return newsMapper.insertNews(news);
    }
}
