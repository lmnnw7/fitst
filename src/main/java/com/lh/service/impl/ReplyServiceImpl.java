package com.lh.service.impl;


import com.lh.mapper.ReplyMapper;
import com.lh.pojo.Reply;
import com.lh.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service//服务类，优先使用
@Primary
public class ReplyServiceImpl implements ReplyService {

    @Autowired(required = false)
    private ReplyMapper replyMapper;

    @Override
    public List<Reply> findAllReply() {
        return replyMapper.findAllReply();
    }

    @Override
    public Reply findReplyByID(Integer id) {
        return replyMapper.findReplyByID(id);
    }

    @Override
    public int deleteReplyByID(Integer id) {
        return replyMapper.deleteReplyByID(id);
    }

    @Override
    public int updateReply(Reply reply) {
        return replyMapper.updateReply(reply);
    }

    @Override
    public List<Reply> findReplyByStr(String searchStr) {
        return replyMapper.findReplyByStr(searchStr);
    }

    @Override
    public int insertReply(Reply reply) {
        return replyMapper.insertReply(reply);
    }
}
