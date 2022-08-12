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

    //SimpleItemService simpleItemService;

    private ItemRepository itemRepository;
    private ItemValidator itemValidator;

    public SimpleItemService (ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }


    @Autowired
    @Qualifier("arrayListItemRepository")
    ArrayListItemRepository arrayListItemRepository;

    @Autowired
    @Qualifier("linkedListItemRepository")
    LinkedListItemRepository linkedListItemRepository;

    @Value("${item.repository.implementation}")
    private String itemRepositoryImplementation;

    @Override
    public Item getById(long id) {
        return null;
    }

    @Override
    public boolean createItem(Item item) {
        System.out.println(itemRepositoryImplementation);
        //simpleItemService.setItemRepository(arrayListItemRepository, linkedListItemRepository);
        //ItemRepository itemRepository1 = new ArrayListItemRepository();
        itemRepository.createItem(item);
        System.out.println("End");
        return true;
    }

    //@Autowired
    public void setItemRepository(ArrayListItemRepository arrayListItemRepository, LinkedListItemRepository linkedListItemRepository) {
        System.out.println(itemRepositoryImplementation);                

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
