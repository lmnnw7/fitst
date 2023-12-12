package com.lh.service;

import com.lh.pojo.News;

import java.util.List;

public interface NewsService {
    News findNewsByID(Integer id);//通过ID查找新闻
    int deleteNewsByID(Integer id);//通过ID删除新闻
    int updateNews(News news);//编辑新闻
    List<News> findNewsByStr(String searchStr);//模糊查询新闻
    List<News> findAllNews();//查找所有新闻
    int insertNews(News news);//添加新闻
}
