package com.example.ex3_tp1_soa_etudiant.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig{

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}