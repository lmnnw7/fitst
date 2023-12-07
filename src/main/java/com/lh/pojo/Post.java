package com.lh.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Post {
    private Integer id;
    private User user_id;
    private String title;
    private String content;
    private Date create_date;
}
