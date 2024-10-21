package com.tiffin.controllers;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.tiffin.dto.OrderDetailsResDTO;

@Controller
public class OrderWebSocketController {

    private final SimpMessagingTemplate messagingTemplate;

    public OrderWebSocketController(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    // This can be used to send notifications to clients
    public void sendOrderNotification(Long vendorId, OrderDetailsResDTO orderDetails) {
        // Send the order notification to the vendor's topic
        messagingTemplate.convertAndSend("/topic/orders/" + vendorId, orderDetails);
    }
}
