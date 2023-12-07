package com.lh.service.impl;

import com.lh.mapper.FavoriteMapper;
import com.lh.pojo.Favorite;
import com.lh.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service//服务类，优先使用
@Primary
public class FavoriteServiceImpl implements FavoriteService {

    @Autowired(required = false)
    private FavoriteMapper favoriteMapper;

    @Override
    public int insertFavorite(Favorite favorite) {
        return favoriteMapper.insertFavorite(favorite);
    }

    @Override
    public List<Favorite> findFavoriteByUID(Integer user_id) {
        return favoriteMapper.findFavoriteByUID(user_id);
    }

    @Override
    public List<Favorite> findFavoriteByDID(Integer device_id) {
        return favoriteMapper.findFavoriteByDID(device_id);
    }
}
