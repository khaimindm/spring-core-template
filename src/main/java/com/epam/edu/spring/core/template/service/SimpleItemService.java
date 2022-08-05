package com.epam.edu.spring.core.template.service;

import com.epam.edu.spring.core.template.entity.Item;
import com.epam.edu.spring.core.template.repository.ArrayListItemRepository;
import com.epam.edu.spring.core.template.repository.ItemRepository;
import com.epam.edu.spring.core.template.repository.LinkedListItemRepository;
import com.epam.edu.spring.core.template.validator.ItemValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:application.properties")
public class SimpleItemService implements ItemService {

    private ItemRepository itemRepository;
    private ItemValidator itemValidator;

    @Value("${item.repository.implementation}")
    private String itemRepositoryImplementation;

    @Override
    public Item getById(long id) {
        return null;
    }

    @Override
    public boolean createItem(Item item) {
        return false;
    }

    @Autowired
    public void setItemRepository(@Qualifier("arrayListItemRepository") ArrayListItemRepository arrayListItemRepository,
                                  @Qualifier("linkedListItemRepository") LinkedListItemRepository linkedListItemRepository) {
        if (itemRepositoryImplementation == null) {
            this.itemRepository = arrayListItemRepository;
        }

        if (itemRepositoryImplementation.equals("array")) {
            this.itemRepository = arrayListItemRepository;
        } else {
            this.itemRepository = linkedListItemRepository;
        }
    }

}
