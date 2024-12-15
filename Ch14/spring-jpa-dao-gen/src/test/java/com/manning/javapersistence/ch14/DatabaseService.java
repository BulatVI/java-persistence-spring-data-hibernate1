 package com.manning.javapersistence.ch14;

import com.manning.javapersistence.ch14.dao.GenericDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import java.math.BigDecimal;

public class DatabaseService {

    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    private EntityManager em;

    @Autowired
    private GenericDao<Item> itemDao;

    @Transactional
    public void init() {
        for (int i = 0; i < 10; i++) {
            String itemName = "Item " + (i + 1);
            Item item = new Item();
            item.setName(itemName);
            Bid bid1 = new Bid(new BigDecimal(1000.0), item);
            Bid bid2 = new Bid(new BigDecimal(1100.0), item);

            itemDao.insert(item);
        }
    }

    @Transactional
    public void clear() {
        em.createQuery("delete from Bid b").executeUpdate();
        em.createQuery("delete from Item i").executeUpdate();
    }

}
