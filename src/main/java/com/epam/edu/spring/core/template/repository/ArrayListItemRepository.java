package com.epam.edu.spring.core.template.repository;

import com.epam.edu.spring.core.template.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.ArrayList;

/**
 * Репозиторий, основанный на классе ArrayList.
 * initialSequence должен браться из application.properties
 */
public class ArrayListItemRepository extends AbstractRepository<Item> implements ItemRepository {

    @Autowired
    @Qualifier("arrayListItemRepository")
    ArrayListItemRepository arrayListItemRepository;

    long idHolder;

    public ArrayListItemRepository() {
        this.holder = new ArrayList<>();                
    }

    @Override
    public Item getById(long id) {
        for (int i = 0; i < holder.size(); i++) {
            Item forVerificationItem = holder.get(i);
            if (forVerificationItem.getId() == id) {
                return forVerificationItem;
            }
        }
        return null;
    }

    @Override
    public boolean createItem(Item item) {
        item.setId(idHolder);
        idHolder++;
        holder.add(item);
        return true;
    }

    @Autowired
    void setInitialSequence(@Qualifier("initialSequenceProperties") int val) {
        this.initialSequence = val;
        arrayListItemRepository.setHolder();
    }

    void setHolder() {
        idHolder = initialSequence;
    }

}
