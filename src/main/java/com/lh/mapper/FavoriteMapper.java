package com.lh.mapper;

import com.lh.pojo.Favorite;

import java.util.List;

public interface FavoriteMapper {
    int insertFavorite(Favorite favorite);
    List<Favorite> findFavoriteByUID(Integer user_id);
    List<Favorite> findFavoriteByDID(Integer device_id);
}
