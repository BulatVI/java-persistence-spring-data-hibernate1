 package com.manning.javapersistence.ch14.dao;

import com.manning.javapersistence.ch14.Bid;
import com.manning.javapersistence.ch14.Item;

public class ItemDaoImpl extends AbstractGenericDao<Item> {

    public ItemDaoImpl() {
        setClazz(Item.class);
    }

    @Override
    public void insert(Item item) {
        em.persist(item);
        for (Bid bid : item.getBids()) {
            em.persist(bid);
        }
    }

    @Override
    public void delete(Item item) {
        for (Bid bid: item.getBids()) {
            em.remove(bid);
        }
        em.remove(item);
    }

}
