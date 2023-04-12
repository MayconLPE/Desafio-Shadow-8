package com.banco.main.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@EnableSwagger2
@Configuration
public class SwaggerConfig {
//    http://localhost:8080/swagger-ui.html
    private ApiInfo metaInfo() {

        ApiInfo apiInfo = new ApiInfo(
                "Banco API REST",
                "API REST Banco cadastrar clientes.",
                "1.0",
                "Terms of Service",
                new Contact("Maycon", "https://github.com/MayconL27/Desafio-Shadow-8",
                        "maycon_leandro2008@hotmail.com"),
                "Apache License Version 2.0",
                "https://www.apache.org/licesen.html", new ArrayList<VendorExtension>()
        );

        return apiInfo;
    }

//    Docket (documento) em forma de @Bean.
    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(metaInfo());
    }


//    //    método para retornar dados de um Contato
//    private Contact contato() {
//        return new Contact(
//                "Maycon",
//                "https://github.com/MayconL27/Desafio-Shadow-8",
//                "maycon_leandro2008@hotmail.com");
//    }

}
