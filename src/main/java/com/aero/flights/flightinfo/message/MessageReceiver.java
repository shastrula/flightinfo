package com.aero.flights.flightinfo.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

@Component
public class MessageReceiver {
    private static Logger logger = LoggerFactory.getLogger(MessageReceiver.class);

    @Autowired
    private ConnectionFactory connectionFactory;
    private JmsTemplate jmsTemplate;

    @PostConstruct
    public void init() {
        this.jmsTemplate = new JmsTemplate(connectionFactory);
    }

    public void receiveMessage(String queueName) {
        Message message = jmsTemplate.receive(queueName);
        TextMessage textMessage = (TextMessage) message;
        try {
            String text = textMessage.getText();
            logger.info("received: " + text);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}