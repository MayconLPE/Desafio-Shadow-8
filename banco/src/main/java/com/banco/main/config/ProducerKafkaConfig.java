package com.banco.main.config;

import com.fasterxml.jackson.databind.ser.std.StringSerializer;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;

//@Configuration
//@EnableKafka
public class ProducerKafkaConfig {



//    @Autowired
//    private KafkaProperties kafkaProperties;
//
//    @Bean
//    public ProducerFactory producerFactory() {
//        var configs = new HashMap<String, Object>();
//        configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
//        configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//        configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//        return new DefaultKafkaProducerFactory<>(configs);
//    }
//    // Template para envio da mensagem.
//    @Bean
//    public KafkaTemplate<String, String> kafkaTemplate() {
//        return new KafkaTemplate<>(producerFactory());
//    }

    // Criar novo topico:
//    @Bean
//    public KafkaAdmin kafkaAdmin() {
//        var configs = new HashMap<String, Object>();
//        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getBootstrapServers());
//        return new KafkaAdmin(configs);
//    }
//    @Bean
//    public NewTopic topic1() {
//        return new NewTopic("topic-1", 10,Short.valueOf("1"));
//        //2.6
////        return TopicBuilder.name("topic-1").build();
//    }

    //2.7
//    @Bean
//    public KafkaAdmin.NewTopics topics() {
//        return new KafkaAdmin.NewTopics(
//                TopicBuilder.name("topic-1").build(),
//                TopicBuilder.name("topic-2").build(),
//                TopicBuilder.name("topic-3").build()
//        );
//    }


}
