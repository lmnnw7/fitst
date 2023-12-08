package com.lh.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Order {
    private Integer id;
    private User buyer_id;
    private Device device_id;
    private Date order_date;
    private String status;
    private String address;
}
