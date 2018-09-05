package com.lqy.springcloud.hystrix.hystrix;

import com.lqy.springcloud.hystrix.model.OrderModel;
import com.lqy.springcloud.hystrix.service.IConsumerServcie;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;

/**
 * Created by Administrator on 2018-09-05.
 */

@Component
public class ConsumerOrderHystrix implements IConsumerServcie {
    @Override
    public OrderModel getOrderByUserId(@PathVariable(value = "id") Integer id) {
        OrderModel model = new OrderModel();
        model.setId(id);
        model.setName("mybbb");
        model.setBirth(new Date());
        return model;
    }
}
