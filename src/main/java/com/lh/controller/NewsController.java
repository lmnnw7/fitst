package com.lh.controller;

import com.lh.pojo.Device;
import com.lh.pojo.News;
import com.lh.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

@RequestMapping("/api")
@RestController
public class NewsController {

    @Autowired(required = false)
    private NewsService newsService;


    @RequestMapping("/findNewsByID")
    public ResponseEntity<?> findNewsByID(@RequestParam Integer id){
        News news=newsService.findNewsByID(id);
        if(news!=null){
            return ResponseEntity.ok(news);
        }
        else return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    //查找所有新闻
    @RequestMapping("/findAllNews")
    public ResponseEntity<?> findAllNews(){
        List<News> NewsList=newsService.findAllNews();
        return ResponseEntity.ok(NewsList);
    }

    //根据id删除新闻
    @RequestMapping("/deleteNewsByID")
    public ResponseEntity<?> deleteNewsByID(@RequestParam Integer id){
        int i=newsService.deleteNewsByID(id);
        if(i>0){
            return ResponseEntity.ok(i);
        }
        else return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    //更新新闻
    @RequestMapping("/updateNews")
    public ResponseEntity<?> updateNews(@RequestBody News news,@RequestParam("file") MultipartFile file){
        try{
            if (!file.isEmpty()) {
                String fileName = file.getOriginalFilename();
                String filePath = "D:/ideawork/Plane/src/main/webapp/img/" + fileName;
                file.transferTo(new File(filePath));
                news.setImage_path("src/img/news/"+fileName);
            }
            int i=newsService.updateNews(news);
            return ResponseEntity.ok(i);
        }catch (Exception exception){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    //查询新闻，模糊查询
    @RequestMapping("/findNewsByStr")
    public ResponseEntity<?> findNewsByStr(@RequestParam(value="searchStr") String searchStr){
        List<News> NewsList=newsService.findNewsByStr(searchStr);
        return ResponseEntity.ok(NewsList);
    }

    //添加新闻
    @RequestMapping("addNews")
    public ResponseEntity<?> addNews(@RequestBody News news,@RequestParam("file") MultipartFile file){
        try{
            if (!file.isEmpty()) {
                String fileName = file.getOriginalFilename();
                String filePath = "D:/ideawork/Plane/src/main/webapp/img/" + fileName;
                file.transferTo(new File(filePath));
                news.setImage_path("src/img/news/"+fileName);
            }
            int i=newsService.insertNews(news);
            return ResponseEntity.ok(i);
        }catch (Exception exception){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
