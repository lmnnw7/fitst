package com.lh.pojo;

import lombok.Data;

@Data
public class Favorite {
    private Integer id;
    private User user_id;
    private Device device_id;
}
