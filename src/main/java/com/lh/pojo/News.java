package com.lh.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class News {
    private Integer id;
    private String title;
    private String author;
    private Date create_date;
    private String content;
    private String image_path;
}
