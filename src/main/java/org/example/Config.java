package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean(name = "applicationName")
    public String applicationName() {
        return "Curso Spring - Sistema de Vendas";
    }
}
