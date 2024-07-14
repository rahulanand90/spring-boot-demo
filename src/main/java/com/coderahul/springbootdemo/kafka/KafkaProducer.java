package com.coderahul.springbootdemo.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message) {
        kafkaTemplate.send(Constants.HELLO_WORLD_TOPIC, message);
        System.out.printf("Message %s has been successfully sent to the topic: %s\n", message,
                Constants.HELLO_WORLD_TOPIC);
    }
}