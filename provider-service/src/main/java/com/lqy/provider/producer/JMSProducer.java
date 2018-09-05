package com.lqy.provider.producer;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Destination;

@Component
public class JMSProducer {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    public void send(String message) {
        Destination destination = new ActiveMQQueue("mymessage");
        jmsMessagingTemplate.convertAndSend(destination, message);
    }
}
