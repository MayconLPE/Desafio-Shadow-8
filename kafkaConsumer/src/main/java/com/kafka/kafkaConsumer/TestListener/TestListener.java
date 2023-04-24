package com.kafka.kafkaConsumer.TestListener;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
@Slf4j
@Component
public class TestListener {

    @KafkaListener(topics = "topic-1", groupId = "group-1")
    public void listen(ConsumerRecord <String, String> consumerRecord) {
        log.info("Thread: {}", Thread.currentThread().getId());
        log.info("Received: {}", consumerRecord.value());
        System.out.println(consumerRecord.value().toString());
    }
}
