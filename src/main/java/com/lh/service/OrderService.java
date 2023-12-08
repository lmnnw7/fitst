package com.lh.service;

import com.lh.pojo.Order;

import java.util.List;

public interface OrderService {

    List<Order> findAllOrder();//查找所有用户
    public Order findOrderByID(Integer id);
    int deleteOrderByID(Integer id);
    int updateOrder(Order order);
    List<Order> findOrderByStr(String searchStr);
    int insertOrder(Order order);
}
