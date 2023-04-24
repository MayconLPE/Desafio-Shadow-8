package com.banco.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;


@RestController
@RequestMapping(value = "/producer")
public class ProducerTestKafkaController {
    private final KafkaTemplate<String, String> kafkaTemplate;
    public ProducerTestKafkaController(KafkaTemplate<String, String> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }


    @GetMapping(value = "/send")
    public ResponseEntity<?> send() {
        kafkaTemplate.send("topic-1", "oi");
        System.out.println(kafkaTemplate.send("topic-1", "oi"));
        return ResponseEntity.ok().build();
    }

}
