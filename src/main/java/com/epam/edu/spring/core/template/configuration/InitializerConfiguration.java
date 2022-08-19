package com.epam.edu.spring.core.template.configuration;

import com.epam.edu.spring.core.template.entity.Color;
import com.epam.edu.spring.core.template.factory.ColorFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;


@Configuration
public class InitializerConfiguration {

    @Bean
    @Lazy(true)
    public ColorFactory colorFactory() {
        return  new ColorFactory();
    }

    @Bean
    @Scope("prototype")
    public Color color() throws Exception {
        return colorFactory().getObject();
    }

}
