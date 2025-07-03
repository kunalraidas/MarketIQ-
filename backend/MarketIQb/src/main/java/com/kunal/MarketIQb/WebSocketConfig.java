package com.kunal.MarketIQb;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.*;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // clients subscribe to /topic/*
        registry.enableSimpleBroker("/topic");
        // client sends messages to /app/*
        registry.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // Frontend will connect to /ws/prices (with SockJS fallback)
        registry.addEndpoint("/ws/prices")
                .setAllowedOriginPatterns("*")
                .withSockJS();
    }
}