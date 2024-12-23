 package com.manning.javapersistence.ch14;

import com.manning.javapersistence.ch14.configuration.SpringConfiguration;
import com.manning.javapersistence.ch14.dao.GenericDao;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SpringConfiguration.class})
//@ContextConfiguration("classpath:application-context.xml")
public class SpringHibernateTest {

    @Autowired
    private DatabaseService databaseService;

    @Autowired
    private GenericDao<Item> itemDao;

    @Autowired
    private GenericDao<Bid> bidDao;

    @BeforeEach
    public void setUp() {
        databaseService.init();
    }

    @Test
    public void testInsertItems() {
        List<Item> itemsList = itemDao.getAll();
        List<Bid> bidsList = bidDao.getAll();
        assertAll(
                () -> assertNotNull(itemsList),
                () -> assertEquals(10, itemsList.size()),
                () -> assertNotNull(itemDao.findByProperty("name", "Item 1")),
                () -> assertNotNull(bidsList),
                () -> assertEquals(20, bidsList.size()),
                () -> assertEquals(10, bidDao.findByProperty("amount", new BigDecimal("1000.00")).size()));
    }

    @Test
    public void testDeleteItem() {
        itemDao.delete(itemDao.findByProperty("name", "Item 2").get(0));
        assertEquals(0, itemDao.findByProperty("name", "Item 2").size());
    }

    @Test
    public void testUpdateItem() {
        List<Item> items = itemDao.findByProperty("name", "Item 1");
        itemDao.update(items.get(0).getId(), "name", "Item 1_updated");
        assertEquals("Item 1_updated", itemDao.getById(items.get(0).getId()).getName());
    }

    @Test
    public void testInsertBid() {
        Item item3 = itemDao.findByProperty("name", "Item 3").get(0);
        Bid newBid = new Bid(new BigDecimal("2000.00"), item3);
        bidDao.insert(newBid);
        assertAll(
                () -> assertEquals(new BigDecimal("2000.00"), bidDao.getById(newBid.getId()).getAmount()),
                () -> assertEquals(21, bidDao.getAll().size()));
    }

    @Test
    public void testUpdateBid() {
        Bid bid = bidDao.findByProperty("amount", new BigDecimal("1000.00")).get(0);
        bidDao.update(bid.getId(), "amount", new BigDecimal("1200.00"));
        assertEquals(new BigDecimal("1200.00"), bidDao.getById(bid.getId()).getAmount());
    }

    @Test
    public void testDeleteBid() {
        bidDao.delete(bidDao.findByProperty("amount", new BigDecimal("1000.00")).get(0));
        assertEquals(19, bidDao.getAll().size());
    }

    @AfterEach
    public void dropDown() {
        databaseService.clear();
    }

}
