package com.banco.main.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class ProducerKafkaConfig {

//    @Autowired
//    private KafkaProperties kafkaProperties;
//    @Bean
//    public ProducerFactory<String, String> producerFactory() {
//        var configs = new HashMap<String, Object>();
//        configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:29092");
//        configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//        configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//        return new DefaultKafkaProducerFactory<>(configs);
//    }
//    @Bean
//    public KafkaTemplate<String, String> kafkaTemplate() {
//        return new KafkaTemplate<>(producerFactory());
//    }
//
//    // Criar novo topico:
//    @Bean
//    public KafkaAdmin kafkaAdmin() {
//        var configs = new HashMap<String, Object>();
//        configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:29092");
//        return new KafkaAdmin(configs);
//    }
//    @Bean
//    public NewTopic topic1() {
//        return new NewTopic("topic-1", 10,Short.valueOf("1"));
//    }



}
