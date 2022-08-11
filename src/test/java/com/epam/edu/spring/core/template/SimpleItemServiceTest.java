package com.epam.edu.spring.core.template;

import com.epam.edu.spring.core.template.entity.Color;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.epam.edu.spring.core.template.configuration.MainConfiguration;
import com.epam.edu.spring.core.template.entity.Item;
import com.epam.edu.spring.core.template.service.SimpleItemService;

@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners({})
@ContextConfiguration(classes = MainConfiguration.class)
public class SimpleItemServiceTest {

    @Autowired
    @Qualifier("item")
    private Item item;

    private Color color;
    
    //SimpleItemService simpleItemService = new SimpleItemService();

    @Autowired
    @Qualifier("simpleItemService")
    SimpleItemService simpleItemService;

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
    public void checkAddingItem() {        
        Item item = new Item(45, "test", 10.5, color);
        simpleItemService.createItem(item);
    }

}