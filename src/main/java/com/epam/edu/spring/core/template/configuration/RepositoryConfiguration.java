package com.epam.edu.spring.core.template.configuration;

import com.epam.edu.spring.core.template.entity.Item;
import com.epam.edu.spring.core.template.repository.ArrayListItemRepository;
import com.epam.edu.spring.core.template.repository.ItemRepository;
import com.epam.edu.spring.core.template.repository.LinkedListItemRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

@Configuration
public class RepositoryConfiguration {

    //private ItemRepository itemRepository;

    @Bean
    ItemRepository arrayListItemRepository() {
        //this.itemRepository = new ArrayListItemRepository();
        return new ArrayListItemRepository();
    }

    @Bean
    ItemRepository linkedListItemRepository() {
        return new LinkedListItemRepository();
    }
}
