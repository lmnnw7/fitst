package com.lh.controller;

import com.lh.pojo.Favorite;
import com.lh.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/favorite")
@RestController
public class FavoriteController {


    @Autowired(required = false)
    private FavoriteService favoriteService;

    //通过UID查找收藏
    @RequestMapping("/findFavoriteByUID")
    public ResponseEntity<?> findFavoriteByUID(@RequestParam Integer user_id){
        List<Favorite> favoriteList=favoriteService.findFavoriteByUID(user_id);
        if(favoriteList!=null){
            return ResponseEntity.ok(favoriteList);
        }
        else return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    //进行收藏
    @RequestMapping("/addFavorite")
    public ResponseEntity<?> addFavorite(@RequestBody Favorite favorite) {
        if (favoriteService.findFavorite(favorite)==null){
            int i=favoriteService.insertFavorite(favorite);
            return ResponseEntity.ok(i);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    //删除收藏
    @RequestMapping("/deleteFavorite")
    public ResponseEntity<?> deleteFavorite(@RequestBody Favorite favorite){
        int i=favoriteService.deleteFavorite(favorite);
        if(i>0){
            return ResponseEntity.ok(i);
        }
        else return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

}
