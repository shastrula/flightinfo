package com.aero.flights.flightinfo.rest;

import com.aero.flights.flightinfo.message.FlightMessageReceiver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MessageRestController {
    private static Logger logger = LoggerFactory.getLogger(MessageRestController.class);
    private static final String DEFAULT_MAPPING = "/message";
    private static final String queueName = "flight-queue";

    @Autowired
    private FlightMessageReceiver receiver;


    @GetMapping(DEFAULT_MAPPING + "/get/{number}")
    public String sendMessage(@PathVariable long number, Model model) throws InterruptedException {
        List<String> messageList = new ArrayList<>();
        for(int i=0;i<number;i++) {
            messageList.add(receiver.receiveMessage());
            Thread.sleep(100);
        }
        model.addAttribute("flights", messageList);

        return "flight/messages";
    }



}
