package com.lh.controller;

import com.lh.pojo.News;
import com.lh.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api")
@RestController
public class NewsController {

    @Autowired(required = false)
    NewsService newsService;

    @RequestMapping("findallnews")
    public ResponseEntity<?> findAllNews(){
        List<News> newsList=newsService.findAllNews();
        return ResponseEntity.ok(newsList);
    }
}
