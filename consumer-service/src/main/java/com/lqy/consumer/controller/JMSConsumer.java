package com.lqy.consumer.controller;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class JMSConsumer {
    @JmsListener(destination = "mymessage")
    public void receive(String message) {
        System.out.println("收到的 message 是：" + message);

    }
}
