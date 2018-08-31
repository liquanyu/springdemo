package com.lqy.consumer.controller;


import com.lqy.consumer.model.OrderModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserController {

//    @Autowired
//    private DiscoveryClient discoveryClient;

    @Autowired
    private RestTemplate restTemplate;
//    @Autowired
//    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/getUserOrder/{id}")
    public OrderModel getUserOrder(@PathVariable Integer id)
    {
        String url = "http://provider-service/getOrderById/"+id;
        OrderModel user = restTemplate.getForObject(url,OrderModel.class);
        return  user;
    }

}
