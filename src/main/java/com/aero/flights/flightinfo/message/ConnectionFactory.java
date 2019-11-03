package com.aero.flights.flightinfo.message;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.stereotype.Component;

@Component
public class ConnectionFactory {

    public javax.jms.ConnectionFactory connectionFactory() {
        javax.jms.ConnectionFactory connectionFactory =
                new ActiveMQConnectionFactory("vm://localhost");
        return connectionFactory;
    }


}
