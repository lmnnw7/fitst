package com.lh.mapper;

import com.lh.pojo.Post;

import java.util.List;

public interface PostMapper {
    List<Post> findAllPost();//查找所有用户
    public Post findPostByID(Integer id);
    int deletePostByID(Integer id);
    int updatePost(Post post);
    List<Post> findPostByStr(String searchStr);
    int insertPost(Post post);
}

