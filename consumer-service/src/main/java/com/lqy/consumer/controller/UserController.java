package com.lqy.consumer.controller;


import com.lqy.consumer.model.OrderModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/getUserOrder/{id}")
    public OrderModel getUserOrder(@PathVariable Integer id)
    {
        String url = "http://provider-service/getOrderById/"+id;

//        ServiceInstance serviceInstance = loadBalancerClient.choose("provider-service");
//        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/getOrderById/"+id;
//        System.out.println(url);
        OrderModel user = restTemplate.getForObject(url,OrderModel.class);

        return  user;
    }

    @GetMapping("/getRibbon")
    public void getRibbon()
    {
        List<ServiceInstance> list = discoveryClient.getInstances("provider-service");
        for (ServiceInstance si : list)
        {
            System.out.println(si.getHost()+":"+si.getPort());
        }

        loadBalancerClient.choose("provider-service");
    }

}
