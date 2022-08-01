package com.epam.edu.spring.core.template.repository;

import com.epam.edu.spring.core.template.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

import java.util.ArrayList;
import java.util.List;

@PropertySource("classpath:application.properties")

/**
 * Репозиторий, основанный на классе ArrayList.
 * initialSequence должен браться из application.properties
 */
public class ArrayListItemRepository extends AbstractRepository<Item> implements ItemRepository {

    @Override
    public Item getById(long id) {
        return null;
    }

    @Override
    public boolean createItem(Item item) {
        this.holder = new ArrayList<>();
        holder.add(item);
        return true;
    }

    @Value("${initial.sequence}")
    private String stringInitialSequenceProperties;
    int initialSequencePropertiesTemp = Integer.parseInt(stringInitialSequenceProperties);

    @Autowired
    void setInitialSequence(int val) {
        //int initialSequenceProperties = Integer.parseInt(stringInitialSequenceProperties);
        this.initialSequence = val;
    }

    //@Autowired
    //@Qualifier("arrayListItemRepository")
    void setHolder() {
    }
}
