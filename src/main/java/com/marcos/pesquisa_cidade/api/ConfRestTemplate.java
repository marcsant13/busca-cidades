package com.marcos.pesquisa_cidade.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfRestTemplate {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
