package com.lh.controller;


import com.lh.pojo.Reply;
import com.lh.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/reply")
@RestController
public class ReplyController {

    @Autowired(required = false)
    private ReplyService replyService;

    //通过PID查找回复
    @RequestMapping("/findReplyByPID")
    public ResponseEntity<?> findReplyByPID(@RequestParam Integer id){
        List<Reply> replyList=replyService.findReplyByPID(id);
        if(replyList!=null){
            return ResponseEntity.ok(replyList);
        }
        else return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @RequestMapping("/findReplyByID")
    public ResponseEntity<?> findNewsByID(@RequestParam Integer id){
        Reply reply=replyService.findReplyByID(id);
        if(reply!=null){
            return ResponseEntity.ok(reply);
        }
        else return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    //查找所有回复
    @RequestMapping("/findAllReply")
    public ResponseEntity<?> findAllReply(){
        List<Reply> ReplyList=replyService.findAllReply();
        return ResponseEntity.ok(ReplyList);
    }

    //根据id删除回复
    @RequestMapping("/deleteReplyByID")
    public ResponseEntity<?> deleteReplyByID(@RequestParam Integer id){
        int i=replyService.deleteReplyByID(id);
        if(i>0){
            return ResponseEntity.ok(i);
        }
        else return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    //更新回复
    @RequestMapping("/updateReply")
    public ResponseEntity<?> updateReply(@RequestBody Reply reply){
        if(reply!=null){
            int i=replyService.updateReply(reply);
            return ResponseEntity.ok(i);
        }
        else return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    //查询回复，模糊查询
    @RequestMapping("/findReplyByStr")
    public ResponseEntity<?> findReplyByStr(@RequestParam(value="searchStr") String searchStr){
        List<Reply> ReplyList=replyService.findReplyByStr(searchStr);
        return ResponseEntity.ok(ReplyList);
    }

    //添加回复
    @RequestMapping("/addReply")
    public ResponseEntity<?> addReply(@RequestBody Reply reply) {
        if (reply!=null){
            int i=replyService.insertReply(reply);
            return ResponseEntity.ok(i);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

}
