package com.lh.service.impl;

import com.lh.mapper.OrderMapper;
import com.lh.mapper.PostMapper;
import com.lh.pojo.Order;
import com.lh.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service//服务类，优先使用
@Primary
public class OrderServiceImpl implements OrderService {

    @Autowired(required = false)
    private OrderMapper orderMapper;

    @Override
    public List<Order> findBuyer(Integer id) {
        return orderMapper.findBuyer(id);
    }

    @Override
    public List<Order> findSeller(Integer id) {
        return orderMapper.findSeller(id);
    }

    @Override
    public Order findOrderByID(Integer id) {
        return orderMapper.findOrderByID(id);
    }

    @Override
    public int deleteOrderByID(Integer id) {
        return orderMapper.deleteOrderByID(id);
    }

    @Override
    public int updateOrder(Order order) {
        return orderMapper.updateOrder(order);
    }

    @Override
    public List<Order> findOrderByStr(String searchStr) {
        return orderMapper.findOrderByStr(searchStr);
    }

    @Override
    public int insertOrder(Order order) {
        return orderMapper.insertOrder(order);
    }

    @Override
    public int confirmOrder(Integer id) {
        return orderMapper.confirmOrder(id);
    }
}
