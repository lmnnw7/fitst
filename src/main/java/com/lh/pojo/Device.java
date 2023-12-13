package com.lh.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Device {
    public Integer id;
    private String name;
    private String description;
    private Double price;
    private String location;
    private String available;
    private Date create_date;
    private String image_path;
    private User user_id;
}
