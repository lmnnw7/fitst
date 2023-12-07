package com.lh.service;

import com.lh.pojo.Favorite;

import java.util.List;

public interface FavoriteService {
    int insertFavorite(Favorite favorite);
    List<Favorite> findFavoriteByUID(Integer user_id);
    List<Favorite> findFavoriteByDID(Integer device_id);
}
