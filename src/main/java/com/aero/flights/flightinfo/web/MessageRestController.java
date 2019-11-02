package com.aero.flights.flightinfo.web;

import com.aero.flights.flightinfo.entity.MessagePayload;
import com.aero.flights.flightinfo.mq.Receiver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.concurrent.TimeUnit;

@Controller
public class MessageRestController {
    private static final String DEFAULT_MAPPING = "/message";
    private static Logger logger = LoggerFactory.getLogger(MessageRestController.class);
    private static final boolean SHOULD_RECEIVE = false;

    private final RabbitTemplate rabbitTemplate;
    private final Receiver receiver;

    public MessageRestController(RabbitTemplate rabbitTemplate, Receiver receiver) {
        this.rabbitTemplate = rabbitTemplate;
        this.receiver = receiver;
    }

    @PostMapping(DEFAULT_MAPPING + "/post")
    public void sendMessage(@RequestBody MessagePayload messagePayload) {
        logger.info("Sending message:" + messagePayload.getMessage() + " for times:" + messagePayload.getCount());
        for(int i=0;i<messagePayload.getCount();i++) {
            String payloadMessage = messagePayload.getMessage() + " " + (i+1) + " of " + messagePayload.getCount();
            rabbitTemplate.convertAndSend(topicExchangeName, "flight.queue.key", payloadMessage);
        }

        if(SHOULD_RECEIVE) {
            try {
                receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                logger.info(e.getMessage(),e);
            }
        }
    }


    private static final String topicExchangeName = "flights-exchange";

    private static final String queueName = "flight-queue";

    @Bean
    Queue queue() {
        return new Queue(queueName, false);
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange(topicExchangeName);
    }

    @Bean
    Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("flight.queue.#");
    }

    //To test if the messages are consumed, uncomment the following:
//    @Bean
//    SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
//                                             MessageListenerAdapter listenerAdapter) {
//        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
//        container.setConnectionFactory(connectionFactory);
//        container.setQueueNames(queueName);
//        container.setMessageListener(listenerAdapter);
//        return container;
//    }
//
//    @Bean
//    MessageListenerAdapter listenerAdapter(Receiver receiver) {
//        return new MessageListenerAdapter(receiver, "receiveMessage");
//    }

}
