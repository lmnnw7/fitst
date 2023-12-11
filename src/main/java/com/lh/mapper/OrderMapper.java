package com.lh.mapper;

import com.lh.pojo.Order;

import java.util.List;

public interface OrderMapper {
    List<Order> findBuyer();//查找买家订单
    List<Order> findSeller();//查找卖家订单
    public Order findOrderByID(Integer id);//通过ID查找订单
    int deleteOrderByID(Integer id);//通过ID删除订单
    int updateOrder(Order order);//编辑订单
    List<Order> findOrderByStr(String searchStr);//模糊查询订单
    int insertOrder(Order order);//添加订单
    int updateAvailableTo0(Integer id);//更改可用性为0
    int confirmOrder(Integer id);//确认订单
}
