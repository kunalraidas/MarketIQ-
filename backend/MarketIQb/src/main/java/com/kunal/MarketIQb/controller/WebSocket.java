package com.kunal.MarketIQb.controller;

//public class WebSocket {
//}


import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.messaging.simp.SimpMessagingTemplate;

@Controller
public class WebSocket {

    private final SimpMessagingTemplate template;

    public WebSocket(SimpMessagingTemplate template) {
        this.template = template;
    }

    @Scheduled(fixedRate = 10000) // every 10 seconds
    public void sendDummyPriceUpdate() {
        double randomPrice = 100 + Math.random() * 50;
        template.convertAndSend("/topic/price", "BTC Price: $" + String.format("%.2f", randomPrice));
    }
}
