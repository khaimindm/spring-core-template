package com.epam.edu.spring.core.template.configuration;

import com.epam.edu.spring.core.template.entity.Item;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

@Configuration
public class RepositoryConfiguration {

    @Bean
    public ArrayList<Item> arrayListItemRepository() {
        ArrayList<> result = new ArrayList<>();

    }
}
