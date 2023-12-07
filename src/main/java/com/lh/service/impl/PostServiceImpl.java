package com.lh.service.impl;

import com.lh.mapper.PostMapper;
import com.lh.pojo.Post;
import com.lh.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service//服务类，优先使用
@Primary
public class PostServiceImpl implements PostService {

    @Autowired(required = false)
    private PostMapper postMapper;

    @Override
    public List<Post> findAllPost() {
        return postMapper.findAllPost();
    }

    @Override
    public Post findPostByID(Integer id) {
        return postMapper.findPostByID(id);
    }

    @Override
    public int deletePostByID(Integer id) {
        return postMapper.deletePostByID(id);
    }

    @Override
    public int updatePost(Post post) {
        return postMapper.updatePost(post);
    }

    @Override
    public List<Post> findPostByStr(String searchStr) {
        return postMapper.findPostByStr(searchStr);
    }

    @Override
    public int insertPost(Post post) {
        return postMapper.insertPost(post);
    }
}
