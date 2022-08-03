package com.epam.edu.spring.core.template.repository;

import com.epam.edu.spring.core.template.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

import java.util.ArrayList;
import java.util.List;

//@PropertySource("classpath:application.properties")

/**
 * Репозиторий, основанный на классе ArrayList.
 * initialSequence должен браться из application.properties
 */
public class ArrayListItemRepository extends AbstractRepository<Item> implements ItemRepository {

    private ItemRepository itemRepository;

    public ArrayListItemRepository() {
        this.holder = new ArrayList<>();
        //this.itemRepository = holder;
    }

    @Override
    public ItemRepository getItemRepository() {
        //itemRepository
        return itemRepository;
    }



    public List getHolder() {
        return holder;
    }

    @Override
    public Item getById(long id) {
        return null;
    }

    @Override
    public boolean createItem(Item item) {
        //this.holder = new ArrayList<>();
        holder.add(item);
        return true;
    }

    @Autowired
    void setInitialSequence(@Qualifier("initialSequenceProperties") int val) {
        this.initialSequence = val;
    }

    void setHolder() {
    }
}
