package com.aero.flights.flightinfo.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;
import java.util.ArrayList;
import java.util.List;

@Component
public class FlightMessageReceiver {
    private static Logger logger = LoggerFactory.getLogger(FlightMessageReceiver.class);

    @Autowired
    private ConnectionFactory connectionFactory;
    private JmsTemplate jmsTemplate;

    @PostConstruct
    public void init() {
        this.jmsTemplate = new JmsTemplate(connectionFactory);
    }

    public String receiveMessage() {
        Message message = jmsTemplate.receive("flight-queue");
            TextMessage textMessage = (TextMessage) message;
            String text = null;

            try {
                text = textMessage.getText();
                logger.info("received: " + text);
            } catch (JMSException e) {
                logger.error(e.getMessage());
            }
            return text;
    }


    @JmsListener(destination = "flight-queue-disabled")
    public void receiveMessageListener(String receivedText) {
        logger.info("Received Text:" + receivedText);

    }


}