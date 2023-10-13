package com.example.diagnostique.projetdiagnostique;

import com.example.diagnostique.projetdiagnostique.configuration.SecurityConfiguration;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class ProjetDiagnostiqueApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjetDiagnostiqueApplication.class, args);
    }
    @Bean
    public ModelMapper modelMapper(){
        return  new ModelMapper();
    }
}

