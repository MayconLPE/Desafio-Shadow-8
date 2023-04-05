package com.kafka.kafkaConsumer.services;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
@Slf4j
@Service
public class RegistrarEventoService {

//    @KafkaListener(topics = "RegitrarEvento", groupId = "MicrosservicoRegitraEvento")
//    public void executar(ConsumerRecord<String, String> record) {
//        long.info("key = {}", record.key());
//
//    }

}
