package com.aero.flights.flightinfo.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.jms.ConnectionFactory;

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

    @JmsListener(destination = "flight-queue")
    public void receiveMessage(String receivedText) {
        logger.info("Received Text:" + receivedText);

    }
}