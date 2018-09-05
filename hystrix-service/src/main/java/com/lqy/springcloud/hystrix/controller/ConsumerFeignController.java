package com.lqy.springcloud.hystrix.controller;

import com.lqy.springcloud.hystrix.model.OrderModel;
import com.lqy.springcloud.hystrix.service.IConsumerServcie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018-09-05.
 */
@RestController
public class ConsumerFeignController {

    @Autowired
    private IConsumerServcie iConsumerServcie;

    @GetMapping("/getUserOrder/{id}")
    public OrderModel getUserOrder(@PathVariable Integer id)
    {

        OrderModel orderModel = iConsumerServcie.getOrderByUserId(id);

        return  orderModel;
    }
}
