 package com.manning.javapersistence.ch12.profile;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class Profile {

    private EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("ch12");

    private FetchTestData storeTestData() throws Exception {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Long[] itemIds = new Long[3];
        Long[] userIds = new Long[3];

        User johndoe = new User("johndoe");
        em.persist(johndoe);
        userIds[0] = johndoe.getId();

        User janeroe = new User("janeroe");
        em.persist(janeroe);
        userIds[1] = janeroe.getId();

        User robertdoe = new User("robertdoe");
        em.persist(robertdoe);
        userIds[2] = robertdoe.getId();

        Item item = new Item("Item One", LocalDate.now().plusDays(1), johndoe);
        em.persist(item);
        itemIds[0] = item.getId();
        for (int i = 1; i <= 3; i++) {
            Bid bid = new Bid(item, robertdoe, new BigDecimal(9 + i));
            item.addBid(bid);
            em.persist(bid);
        }

        item = new Item("Item Two", LocalDate.now().plusDays(1), johndoe);
        em.persist(item);
        itemIds[1] = item.getId();
        for (int i = 1; i <= 1; i++) {
            Bid bid = new Bid(item, janeroe, new BigDecimal(2 + i));
            item.addBid(bid);
            em.persist(bid);
        }

        item = new Item("Item Three", LocalDate.now().plusDays(2), janeroe);
        em.persist(item);
        itemIds[2] = item.getId();
        for (int i = 1; i <= 1; i++) {
            Bid bid = new Bid(item, johndoe, new BigDecimal(3 + i));
            item.addBid(bid);
            em.persist(bid);
        }

        em.getTransaction().commit();
        em.close();

        FetchTestData testData = new FetchTestData();
        testData.items = new TestData(itemIds);
        testData.users = new TestData(userIds);
        return testData;
    }

    @Test
    public void fetchWithProfile() throws Exception {
        FetchTestData testData = storeTestData();

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Long ITEM_ID = testData.items.getFirstId();

            /* 
                The <code>Item#seller</code> is mapped lazy, so the default fetch plan
                will only retrieve the <code>Item</code> instance.
             */
        Item item = em.find(Item.class, ITEM_ID);

        assertFalse(Hibernate.isInitialized(item.getSeller()));

        em.clear();
            /* 
                You need the Hibernate API to enable a profile, it is then active for any operation in that
                unit of work. Now the <code>Item#seller</code> will be fetched with a join in the same SQL
                statement whenever an <code>Item</code> is loaded with this <code>EntityManager</code>.
             */
        em.unwrap(Session.class).enableFetchProfile(Item.PROFILE_JOIN_SELLER);
        item = em.find(Item.class, ITEM_ID);

        em.clear();
        assertNotNull(item.getSeller().getUsername());

        em.clear();
            /* 
                You can overlay another profile on the same unit of work, now the <code>Item#seller</code>
                and the <code>Item#bids</code> collection will be fetched with a join in the same SQL
                statement whenever an <code>Item</code> is loaded.
             */
        em.unwrap(Session.class).enableFetchProfile(Item.PROFILE_JOIN_BIDS);
        item = em.find(Item.class, ITEM_ID);

        em.clear();
        assertNotNull(item.getSeller().getUsername());
        assertTrue(item.getBids().size() > 0);

        em.getTransaction().commit();
        em.close();
    }

}
