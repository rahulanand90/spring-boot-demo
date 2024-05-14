package com.coderahul.springbootdemo.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @SuppressWarnings("FieldCanBeLocal")
    private final String TOPIC_NAME= "any-topic-name"; // Replace with your desired topic name

    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message) {
        kafkaTemplate.send(TOPIC_NAME, message);
        System.out.printf("Message %s has been successfully sent to the topic: %s\n", message, TOPIC_NAME);
    }
}