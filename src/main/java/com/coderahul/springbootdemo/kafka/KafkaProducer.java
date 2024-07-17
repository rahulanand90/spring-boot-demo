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
        for(int i=0; i<10000; i++){
            kafkaTemplate.send(Constants.HELLO_WORLD_TOPIC, message);
        }

        System.out.printf("Message has been successfully sent to the topic: %s\n", Constants.HELLO_WORLD_TOPIC);
    }
}