package com.lh.controller;

import com.lh.pojo.Post;
import com.lh.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

@RequestMapping("/api")
@RestController
public class PostController {

    @Autowired(required = false)
    private PostService postService;

    //通过ID查找贴子
    @RequestMapping("/findPostByID")
    public ResponseEntity<?> findNewsByID(@RequestParam Integer id){
        Post post=postService.findPostByID(id);
        if(post!=null){
            return ResponseEntity.ok(post);
        }
        else return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    //查找所有贴子
    @RequestMapping("/findAllPost")
    public ResponseEntity<?> findAllPost(){
        List<Post> postList=postService.findAllPost();
        return ResponseEntity.ok(postList);
    }

    //根据id删除贴子
    @RequestMapping("/deletePostByID")
    public ResponseEntity<?> deletePostByID(@RequestParam Integer id){
        int i=postService.deletePostByID(id);
        if(i>0){
            return ResponseEntity.ok(i);
        }
        else return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    //更新贴子
    @RequestMapping("/updatePost")
    public ResponseEntity<?> updatePost(Post post,@RequestParam("file") MultipartFile file){
        try{
            if (!file.isEmpty()) {
                String fileName = file.getOriginalFilename();
                String filePath = "D:/ideawork/FJYL/src/main/resources/static/img/" + fileName;
                file.transferTo(new File(filePath));
                post.setImage_path("src/img/post/"+fileName);
            }
            int i=postService.updatePost(post);
            return ResponseEntity.ok(i);
        }catch (Exception exception){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    //查询贴子，模糊查询
    @RequestMapping("/findPostByStr")
    public ResponseEntity<?> findPostByStr(@RequestParam(value="searchStr") String searchStr){
        List<Post> postList=postService.findPostByStr(searchStr);
        return ResponseEntity.ok(postList);
    }

    //添加贴子
    @RequestMapping("addPost")
    public ResponseEntity<?> addPost(Post post,@RequestParam("file") MultipartFile file){
        try{
            if (!file.isEmpty()) {
                String fileName = file.getOriginalFilename();
                String filePath = "D:/ideawork/FJYL/src/main/resources/static/img/" + fileName;
                file.transferTo(new File(filePath));
                post.setImage_path("src/img/post/"+fileName);
            }
            int i=postService.insertPost(post);
            return ResponseEntity.ok(i);
        }catch (Exception exception){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
