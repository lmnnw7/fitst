package com.lh.mapper;

import com.lh.pojo.Reply;

import java.util.List;

public interface ReplyMapper {
    List<Reply> findAllReply();//查找所有用户
    public Reply findReplyByID(Integer id);
    int deleteReplyByID(Integer id);
    int updateReply(Reply reply);
    List<Reply> findReplyByStr(String searchStr);
    int insertReply(Reply reply);
}
