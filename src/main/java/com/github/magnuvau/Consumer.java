package com.github.magnuvau;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @KafkaListener(id = "consumer", topics = "hello_topic")
    public void listen(String in) {
        System.out.println(in);
    }
}
