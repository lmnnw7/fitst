package com.lh.pojo;

import lombok.Data;

@Data
public class Emergency {
    private Integer id;
    private String name;
    private Double longitude;
    private Double latitude;
    private String phone;
    private String description;
}
