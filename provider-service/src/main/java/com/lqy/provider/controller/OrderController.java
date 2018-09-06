package com.lqy.provider.controller;

import com.lqy.provider.model.OrderModel;
import com.lqy.provider.producer.JMSProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class OrderController {

    @Value("${server.port}")
    private String port;

    @Autowired
    private JMSProducer jp;

    @GetMapping("/getOrderById/{id}")
    public OrderModel  getOrderByUserId(@PathVariable Integer id)
    {
        OrderModel model = new OrderModel();
        model.setId(id);
        model.setName("Jome");
        model.setBirth(new Date());

        System.out.println("port = " + port);

        return model;
    }

//    @GetMapping("/sendMessage")
//    public String  sendMessage(String msg)
//    {
//        jp.send(msg);
//        return "success";
//    }
}
