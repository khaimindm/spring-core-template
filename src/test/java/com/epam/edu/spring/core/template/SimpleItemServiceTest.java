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

@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners({})
@ContextConfiguration(classes = MainConfiguration.class)
public class SimpleItemServiceTest {

    @Autowired
    @Qualifier("item")
    private Item item;

    private Color color;

    @Test
    public void checkCreateItem() {
        long id = 10;
        //item = new Item(10L, "test", 10, color);
        Item item = new Item(id, "test", 10, color);
        System.out.println(item.getId());
        item.setId(2555L);
        //item.setPrice(10);
        System.out.println(item.getId());
        Assert.assertTrue(item.getPrice() == 10);;
        //Assert.isTrue(item.getPrice() == 10, "The Item price is not 10");
    }

}