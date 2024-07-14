package com.coderahul.springbootdemo.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    private static int counter = 0;
    @KafkaListener(topics = Constants.HELLO_WORLD_TOPIC, groupId = Constants.CONSUMER_GROUP_ID)
    public void consumeHelloWorldMessage(String message) throws InterruptedException {
        Thread.sleep(5000);
        System.out.println("Received message: " + message + " ::counter:: " + counter);
        counter++;
    }
}
