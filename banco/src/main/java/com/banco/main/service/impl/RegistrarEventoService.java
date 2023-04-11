package com.banco.main.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RegistrarEventoService {

    private final KafkaTemplate<String, Object> template;

    public <T> void adicionarEvento(String topico, T dados) {
        template.send(topico, dados);
    }
}
