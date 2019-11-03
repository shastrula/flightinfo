package com.aero.flights.flightinfo.message;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ConnectionFactory {

    @Value("${ACTIVE_MQ_BROKER_URL}")
    private String brokerURL;

    public javax.jms.ConnectionFactory connectionFactory() {
        brokerURL = "vm://localhost";
        javax.jms.ConnectionFactory connectionFactory =
                new ActiveMQConnectionFactory(brokerURL);
        return connectionFactory;
    }


}
