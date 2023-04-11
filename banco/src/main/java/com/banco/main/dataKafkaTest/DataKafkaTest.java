package com.banco.main.dataKafkaTest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataKafkaTest {

    private String id;
    private String nomeProduto;
    private BigDecimal valor;
}
