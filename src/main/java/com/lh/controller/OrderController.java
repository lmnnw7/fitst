package com.lh.controller;

import com.lh.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
public class OrderController {

    @Autowired(required = false)
    private OrderService orderService;
}
