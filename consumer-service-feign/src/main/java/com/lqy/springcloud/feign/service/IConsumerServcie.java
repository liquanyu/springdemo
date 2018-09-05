package com.lqy.springcloud.feign.service;

import com.lqy.springcloud.feign.model.OrderModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by Administrator on 2018-09-05.
 */
@FeignClient("provider-service")
public interface IConsumerServcie {


    @GetMapping("/getOrderById/{id}")
    public OrderModel getOrderByUserId(@PathVariable(value="id") Integer id);

}
