package com.lqy.springcloud.hystrix.service;

import com.lqy.springcloud.hystrix.hystrix.ConsumerOrderHystrix;
import com.lqy.springcloud.hystrix.model.OrderModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by Administrator on 2018-09-05.
 */
@FeignClient(value = "provider-service",fallback = ConsumerOrderHystrix.class)
public interface IConsumerServcie {

    @GetMapping("/getOrderById/{id}")
    public OrderModel getOrderByUserId(@PathVariable(value = "id") Integer id);

}
