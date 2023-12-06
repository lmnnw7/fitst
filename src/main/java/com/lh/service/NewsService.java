package com.lh.service;

import com.lh.pojo.News;

import java.util.List;

public interface NewsService {
    public News findNewsByID(Integer id);
    int deleteNewsByID(Integer id);
    int updateNews(News news);
    List<News> findNewsByStr(String searchStr);
    List<News> findAllNews();
    int insertNews(News news);
}
