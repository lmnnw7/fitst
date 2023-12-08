package com.lh.service;

import com.lh.pojo.Post;

import java.util.List;

public interface PostService {
    List<Post> findAllPost();//查找所有贴子
    public Post findPostByID(Integer id);//通过ID查找贴子
    int deletePostByID(Integer id);//通过ID删除贴子
    int updatePost(Post post);//编辑贴子
    List<Post> findPostByStr(String searchStr);//模糊查询贴子
    int insertPost(Post post);//添加贴子
}
