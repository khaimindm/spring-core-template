package com.epam.edu.spring.core.template.configuration;

import com.epam.edu.spring.core.template.entity.Color;
import com.epam.edu.spring.core.template.entity.Item;
import com.epam.edu.spring.core.template.factory.ColorFactory;
import com.epam.edu.spring.core.template.service.SimpleItemService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;


@Configuration
public class InitializerConfiguration {

    @Bean
    @Lazy(true)
    public ColorFactory colorFactory() {
        ColorFactory factory = new ColorFactory();
        return factory;
    }

    @Bean
    @Scope("prototype")
    public Color color() throws Exception {
        return colorFactory().getObject();
    }

    /*@Bean
    @Lazy(true)
    @Scope("prototype")
    public Item item(long id, String name, double price, Color color) {
        return new Item(id, name, price, color);
    }*/

    @Bean
    public SimpleItemService simpleItemService() {
        return new SimpleItemService();
    }
}
