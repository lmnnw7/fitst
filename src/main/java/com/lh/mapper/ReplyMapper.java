package com.lh.mapper;

import com.lh.pojo.Reply;

import java.util.List;

public interface ReplyMapper {
    List<Reply> findAllReply();//查找所有回复
    Reply findReplyByID(Integer id);//通过ID查找回复
    List<Reply> findReplyByPID(Integer id);//通过贴子的ID来查找回复
    int deleteReplyByID(Integer id);//通过ID删除回复
    int updateReply(Reply reply);//编辑回复
    List<Reply> findReplyByStr(String searchStr);//模糊查询回复
    int insertReply(Reply reply);//添加回复
}
