package com.lh.controller;

import com.lh.pojo.Order;
import com.lh.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/order")
@RestController
public class OrderController {

    @Autowired(required = false)
    private OrderService orderService;

    //通过ID查找订单
    @RequestMapping("/findOrderByID")
    public ResponseEntity<?> findNewsByID(@RequestParam Integer id){
        Order order=orderService.findOrderByID(id);
        if(order!=null){
            return ResponseEntity.ok(order);
        }
        else return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    //查找买家订单
    @RequestMapping("/findBuyer")
    public ResponseEntity<?> findBuyer(){
        List<Order> OrderList=orderService.findBuyer();
        return ResponseEntity.ok(OrderList);
    }

    //查找卖家订单
    @RequestMapping("/findSeller")
    public ResponseEntity<?> findSeller(){
        List<Order> OrderList=orderService.findSeller();
        return ResponseEntity.ok(OrderList);
    }

    //确认订单
    @RequestMapping("/confirmOrder")
    public ResponseEntity<?> confirmOrder(@RequestParam Integer id){
        int i=orderService.confirmOrder(id);
        if(i>0){
            return ResponseEntity.ok(i);
        }
        else return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    //根据ID删除订单
    @RequestMapping("/deleteOrderByID")
    public ResponseEntity<?> deleteOrderByID(@RequestParam Integer id){
        int i=orderService.deleteOrderByID(id);
        if(i>0){
            return ResponseEntity.ok(i);
        }
        else return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    //更新订单
    @RequestMapping("/updateOrder")
    public ResponseEntity<?> updateOrder(@RequestBody Order order){
        if(order!=null){
            int i=orderService.updateOrder(order);
            return ResponseEntity.ok(i);
        }
        else return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    //查询订单，模糊查询
    @RequestMapping("/findOrderByStr")
    public ResponseEntity<?> findOrderByStr(@RequestParam(value="searchStr") String searchStr){
        List<Order> OrderList=orderService.findOrderByStr(searchStr);
        return ResponseEntity.ok(OrderList);
    }

    //添加订单
    @RequestMapping("/addOrder")
    public ResponseEntity<?> addOrder(@RequestBody Order order) {
        if (order!=null){
            int i=orderService.insertOrder(order);
            int j=orderService.updateAvailableTo0(order.getDevice_id().id);
            return ResponseEntity.ok(i+j);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }


}
