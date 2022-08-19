package com.epam.edu.spring.core.template.configuration;

import com.epam.edu.spring.core.template.repository.ArrayListItemRepository;
import com.epam.edu.spring.core.template.repository.LinkedListItemRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:application.properties")
@Configuration
public class RepositoryConfiguration {

    @Bean
    ArrayListItemRepository arrayListItemRepository() {        
        return new ArrayListItemRepository();
    }

    @Bean
    LinkedListItemRepository linkedListItemRepository() {
        return new LinkedListItemRepository();
    }

    @Value("${initial.sequence}")
    private String stringInitialSequenceProperties;

    @Bean
    int initialSequenceProperties() {
        int initialSequenceProperties = Integer.parseInt(stringInitialSequenceProperties);
        return initialSequenceProperties;
    }

}
