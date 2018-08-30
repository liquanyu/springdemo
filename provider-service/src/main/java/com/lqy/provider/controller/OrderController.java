package com.lqy.provider.controller;

import com.lqy.provider.model.OrderModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class OrderController {

    @GetMapping("/getOrderById/{id}")
    public OrderModel  getOrderByUserId(@PathVariable Integer id)
    {
        OrderModel model = new OrderModel();
        model.setId(id);
        model.setName("Jome");
        model.setBirth(new Date());
        return model;
    }


}
