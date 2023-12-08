package com.lh.service;

import com.lh.pojo.Reply;

import java.util.List;

public interface ReplyService {
    List<Reply> findAllReply();//查找所有用户
    public Reply findReplyByID(Integer id);
    public List<Reply> findReplyByPID(Integer id);
    int deleteReplyByID(Integer id);
    int updateReply(Reply reply);
    List<Reply> findReplyByStr(String searchStr);
    int insertReply(Reply reply);
}
