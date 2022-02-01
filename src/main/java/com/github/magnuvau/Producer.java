package com.github.magnuvau;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Producer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void send(String message) {
        kafkaTemplate.send("hello_topic", message);
    }

    @PostConstruct
    public void barrage() {
        try {
            for (int i = 0; i < 10; i++) {
                send("Hello, world!");
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Interrupted...");
        }
    }
}
