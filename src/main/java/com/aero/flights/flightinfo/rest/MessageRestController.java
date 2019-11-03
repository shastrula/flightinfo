package com.aero.flights.flightinfo.rest;

import com.aero.flights.flightinfo.entity.MessagePayload;
import com.aero.flights.flightinfo.message.MessageReceiver;
import com.aero.flights.flightinfo.message.MessageSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageRestController {
    private static final String DEFAULT_MAPPING = "/message";
    private static Logger logger = LoggerFactory.getLogger(MessageRestController.class);
    private static final boolean SHOULD_RECEIVE = true;
    private static final String queueName = "flight-queue";

    @Autowired
    private MessageSender messageSender;

    @Autowired
    private MessageReceiver messageReceiver;

    @PostMapping(DEFAULT_MAPPING + "/post")
    public void sendMessage(@RequestBody MessagePayload messagePayload) {
        logger.info("Sending message:" + messagePayload.getMessage() + " for times:" + messagePayload.getCount());
        for(int i=0;i<messagePayload.getCount();i++) {
            String payloadMessage = messagePayload.getMessage() + " " + (i+1) + " of " + messagePayload.getCount();
            messageSender.sendMessage(queueName, payloadMessage);
        }

        if(SHOULD_RECEIVE) {
                messageReceiver.receiveMessage(queueName);
        }
    }

}
