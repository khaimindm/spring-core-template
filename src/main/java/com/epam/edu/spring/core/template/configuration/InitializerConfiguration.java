package com.epam.edu.spring.core.template.configuration;

import com.epam.edu.spring.core.template.entity.Color;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InitializerConfiguration {

    @Bean
    public Color color() {
        return null;
    }
}
