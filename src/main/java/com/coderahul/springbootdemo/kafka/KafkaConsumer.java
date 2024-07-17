package com.coderahul.springbootdemo.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class KafkaConsumer {

    private static int counter = 0;
    @KafkaListener(topics = Constants.HELLO_WORLD_TOPIC, groupId = Constants.CONSUMER_GROUP_ID, concurrency = "1000")
    public void consumeHelloWorldMessage(String message) throws InterruptedException {
        System.out.println("Received message from : " + message + " ::counter:: " + counter);
        counter++;
    }
}
