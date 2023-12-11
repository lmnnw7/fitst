package com.lh.service;

import com.lh.pojo.Favorite;

import java.util.List;

public interface FavoriteService {
    int insertFavorite(Favorite favorite);//添加收藏
    List<Favorite> findFavoriteByUID(Integer user_id);//通过用户ID查找收藏
    List<Favorite> findFavoriteByDID(Integer device_id);//通过设备ID查找收藏
    int deleteFavoriteByID(Integer id);//删除收藏
}
