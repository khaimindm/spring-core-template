package com.epam.edu.spring.core.template;

import com.epam.edu.spring.core.template.configuration.MainConfiguration;
import com.epam.edu.spring.core.template.entity.Color;
import com.epam.edu.spring.core.template.entity.Item;
import com.epam.edu.spring.core.template.factory.ColorFactory;
import com.epam.edu.spring.core.template.service.SimpleItemService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.reflect.InvocationTargetException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MainConfiguration.class)
public class SimpleItemServiceTest {

    @Autowired
    @Qualifier("colorFactory")
    private ColorFactory colorFactory;

    @Autowired
    @Qualifier("simpleItemService")
    SimpleItemService simpleItemService;

    @Autowired
    @Qualifier("color")
    Color color;

    @Test
    public void checkCreationOfNewItem() {
        Item item = new Item(45, "test", 10, color);
        Assert.assertNotNull("Item is not created", item);
    }

    @Test
    public void checkIfItemWasCreatedCorrectly() {        
        Item item = new Item(45, "test", 10.5, color);
        Assert.assertTrue(item.getPrice() == 10.5);
    }

    @Test
    public void checkAddingItem() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

        try {
            color = colorFactory.getObject();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Item item1 = new Item(0, "name1", 1.0, color);
        Item item2 = new Item(0, "name2", 2.0, color);
        Item item3 = new Item(0, "name3", 3.0, color);

        simpleItemService.createItem(item1);
        simpleItemService.createItem(item2);
        simpleItemService.createItem(item3);
    }

    @Test
    public void checkGetById() {

        try {
            color = colorFactory.getObject();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Item item1 = new Item(0, "name1", 1.0, color);
        Item item2 = new Item(0, "name2", 2.0, color);
        Item item3 = new Item(0, "name3", 3.0, color);

        simpleItemService.createItem(item1);
        simpleItemService.createItem(item2);
        simpleItemService.createItem(item3);        

        Item byIdItem = simpleItemService.getById(42);
        Assert.assertTrue(byIdItem.getName().equals("name1"));
        Assert.assertTrue(byIdItem.getPrice() == 1.0);
    }

}