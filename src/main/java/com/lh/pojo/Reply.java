package com.lh.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Reply {
    private Integer id;
    private User user_id;
    private Post post_id;
    private String content;
    private Date create_date;
}
