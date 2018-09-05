package com.lqy.springcloud.feign.controller;

import com.lqy.springcloud.feign.model.OrderModel;
import com.lqy.springcloud.feign.service.IConsumerServcie;
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
