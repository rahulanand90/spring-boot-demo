package com.coderahul.springbootdemo.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    @KafkaListener(topics = "any-topic-name", groupId = "your-consumer-group-id")
    public void consumeMessage(String message) {
        System.out.println("Received message: " + message);
    }
}
