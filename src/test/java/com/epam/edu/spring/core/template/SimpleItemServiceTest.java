package com.epam.edu.spring.core.template;

import com.epam.edu.spring.core.template.entity.Color;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.epam.edu.spring.core.template.configuration.MainConfiguration;
import com.epam.edu.spring.core.template.entity.Item;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MainConfiguration.class)
public class SimpleItemServiceTest {

    @Autowired
    private Item item;

    private Color color;

    @Test
    public void checkCreateItem() {
        item = new Item(10, "test", 10, color);
        Assert.assertTrue(item.getPrice() == 10);
        //Assert.isTrue(item.getPrice() == 10, "The Item price is not 10");
    }

}