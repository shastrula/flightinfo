package com.aero.flights.flightinfo.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageReceiver {
    private static Logger logger = LoggerFactory.getLogger(MessageReceiver.class);

    @JmsListener(destination = "flight-queue")
    public void receiveMessage(String receivedText) {
        logger.info("Received Text:" + receivedText);

    }
}