package com.aero.flights.flightinfo.entity;

import com.aero.flights.flightinfo.message.MessageSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;

public class AuditListener {
    private static Logger logger = LoggerFactory.getLogger(AuditListener.class);
    private static final String queueName = "flight-queue";
    @Autowired
    private MessageSender messageSender;

    @PostPersist
    @PostUpdate
    @PostRemove
    private void beforeAnyOperation(Object auditEvent) {
        logger.info("Received database event: " + auditEvent);
        messageSender.sendMessage(queueName, auditEvent);
    }

}