package com.epam.edu.spring.core.template;

import com.epam.edu.spring.core.template.entity.Color;
import com.epam.edu.spring.core.template.service.ItemService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.ReflectionUtils;
import java.lang.reflect.*;

import com.epam.edu.spring.core.template.configuration.MainConfiguration;
import com.epam.edu.spring.core.template.entity.Item;
import com.epam.edu.spring.core.template.repository.ArrayListItemRepository;
import com.epam.edu.spring.core.template.repository.ItemRepository;
import com.epam.edu.spring.core.template.service.SimpleItemService;

@RunWith(SpringJUnit4ClassRunner.class)
//@TestExecutionListeners({})
@ContextConfiguration(classes = MainConfiguration.class)
public class SimpleItemServiceTest {

    /*@Autowired
    @Qualifier("item")
    private Item item;*/

    @Autowired
    ArrayListItemRepository arrayListItemRepository;

    private Color color;

    @Autowired
    @Qualifier("simpleItemService")
    SimpleItemService simpleItemService;

    //@Autowired
    //public SimpleItemServiceTest simpleItemServiceTest;

    @Test
    public void checkCreationOfNewItem() {
        //long id = 45;
        //item = new Item(10L, "test", 10, color);
        Item item = new Item(45, "test", 10, color);
        Assert.assertNotNull("Item is not created", item);

        //System.out.println(item.getId());
        //item.setId(2555L);
        //item.setPrice(10);
        //System.out.println(item.getId());
        //Assert.assertTrue(item.getPrice() == 10);
        //Assert.isTrue(item.getPrice() == 10, "The Item price is not 10");
    }

    @Test
    public void checkIfItemWasCreatedCorrectly() {        
        Item item = new Item(45, "test", 10.5, color);
        Assert.assertTrue(item.getPrice() == 10.5);
    }

    @Test
    public void checkAddingItem() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {        
        Item item = new Item(0, "test", 10.5, color);
        //ItemRepository itemRepository = arrayListItemRepository;
        //ItemService itemService = new SimpleItemService(itemRepository);

        //itemService.createItem(item);

        simpleItemService.createItem(item);

        //System.out.println(itemRepository.getById(45).toString());
    }

}