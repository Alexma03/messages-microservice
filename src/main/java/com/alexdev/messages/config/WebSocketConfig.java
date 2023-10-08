package com.alexdev.messages.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * This class is the configuration class for WebSocket in the Spring application.
 * It enables WebSocket message broker and registers Stomp endpoints for WebSocket communication.
 * The Stomp endpoints are "/ws" and SockJS is used for WebSocket fallback options.
 * The message broker is configured with application destination prefix "/app" and enables simple broker for topic "/topic".
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    /**
     * Used to register a STOMP (Simple Text Oriented Messaging Protocol) "/ws" endpoint with
     * setAllowedOrigins("*") to allow all origins to access the endpoint.
     * SockJS support for browsers that do not support WebSocket.
     * This method is called when a WebSocket client tries to connect to the server.
     * @param registry the StompEndpointRegistry to register the endpoint with
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry
                .addEndpoint("/ws")
                .setAllowedOrigins("*")
                .withSockJS();
    }

    /**
     * Configures the message broker registry for WebSocket communication.
     * The application destination prefix /app is used to differentiate between messages that are intended for
     * application-specific destinations and those that are intended for broker-specific destinations. 
     * The /topic destination is used to broadcast messages to all connected clients.
     * @param registry the message broker registry to be configured
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.setApplicationDestinationPrefixes("/app");
        registry.enableSimpleBroker("/topic");
    }
}
