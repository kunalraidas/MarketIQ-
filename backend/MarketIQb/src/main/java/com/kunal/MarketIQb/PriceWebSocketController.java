package com.kunal.MarketIQb;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

@Controller
public class PriceWebSocketController {

    private final SimpMessagingTemplate template;

    public PriceWebSocketController(SimpMessagingTemplate template) {
        this.template = template;
    }

    // every 10 seconds, send a dummy BTC price
    @Scheduled(fixedRate = 10000)
    public void sendDummyPrice() {
        double price = 20000 + Math.random() * 5000;  // random between 20000–25000
        String payload = String.format("BTC/USD: $%.2f", price);
        template.convertAndSend("/topic/price", payload);
    }
}