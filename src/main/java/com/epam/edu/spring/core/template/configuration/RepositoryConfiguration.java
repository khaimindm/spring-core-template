package com.epam.edu.spring.core.template.configuration;

import com.epam.edu.spring.core.template.entity.Item;
import com.epam.edu.spring.core.template.repository.AbstractRepository;
import com.epam.edu.spring.core.template.repository.ArrayListItemRepository;
import com.epam.edu.spring.core.template.repository.ItemRepository;
import com.epam.edu.spring.core.template.repository.LinkedListItemRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.ArrayList;
import java.util.List;

@PropertySource("classpath:application.properties")
@Configuration
public class RepositoryConfiguration {

    //private ItemRepository itemRepository;

    @Bean
    ItemRepository arrayListItemRepository() {
        return ArrayListItemRepository.getHolder;
    }

    @Bean
    ItemRepository linkedListItemRepository() {
        return new LinkedListItemRepository();
    }

    @Value("${initial.sequence}")
    private String stringInitialSequenceProperties;

    //int initialSequenceProperties = Integer.parseInt(stringInitialSequenceProperties);

    @Bean
    int initialSequenceProperties() {
        int initialSequenceProperties = Integer.parseInt(stringInitialSequenceProperties);
        return initialSequenceProperties;
    }
}
