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
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@PropertySource("classpath:application.properties")
public class SimpleItemService implements ItemService {

    //SimpleItemService simpleItemService;

    private ItemRepository itemRepository;
    private ItemValidator itemValidator;
    private String itemRepositoryImplementation;

    @Autowired
    public SimpleItemService (@Qualifier("arrayListItemRepository") ArrayListItemRepository arrayListItemRepository,
                              @Qualifier("linkedListItemRepository") LinkedListItemRepository linkedListItemRepository,
                              @Value("${item.repository.implementation}") String itemRepositoryImplementation) {

        this.itemRepositoryImplementation = itemRepositoryImplementation;

        if (itemRepositoryImplementation.equals("linked")) {
            this.itemRepository = linkedListItemRepository;
        } else {
            this.itemRepository = arrayListItemRepository;
        }
    }

    /*public String getItemRepositoryImplementation() {
        return itemRepositoryImplementation;
    }*/

    @Override
    public Item getById(long id) {
        return null;
    }

    @Override
    public boolean createItem(Item item) {
        itemRepository.createItem(item);
        return true;
    }

    //@Autowired
    /*public void setItemRepository(ArrayListItemRepository arrayListItemRepository, LinkedListItemRepository linkedListItemRepository) {

        if (itemRepositoryImplementation == null || itemRepositoryImplementation == "" || itemRepositoryImplementation.equals("array")) {
            this.itemRepository = arrayListItemRepository;
        } else {
            this.itemRepository = linkedListItemRepository;
        }
    }*/

}
