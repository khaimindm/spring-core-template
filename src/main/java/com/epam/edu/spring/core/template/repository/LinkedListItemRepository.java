package com.epam.edu.spring.core.template.repository;

import com.epam.edu.spring.core.template.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.LinkedList;
import java.util.Random;

/**
 * Репозиторий, основанный на классе LinkedList.
 * initialSequence должен случайно генерироваться из диапазона от 1 до 100
 */
public class LinkedListItemRepository extends AbstractRepository<Item> implements ItemRepository {

    @Autowired
    @Qualifier("linkedListItemRepository")
    LinkedListItemRepository linkedListItemRepository;

    long idHolder;

    public LinkedListItemRepository() {
        this.holder = new LinkedList<>();
    }

    Random rand = new Random();

    @Override
    public Item getById(long id) {
        return null;
    }

    @Override
    public boolean createItem(Item item) {
        if (initialSequence == 0) {
            int x = 1 + rand.nextInt(100 - 1 + 1);
            linkedListItemRepository.setInitialSequence(x);
        }

        item.setId(idHolder);
        idHolder++;
        holder.add(item);
        return true;
    }

    void setInitialSequence(int val) {
        this.initialSequence = val;
        linkedListItemRepository.setHolder();
    }
            
    void setHolder() {
        idHolder = initialSequence;
    }
}
