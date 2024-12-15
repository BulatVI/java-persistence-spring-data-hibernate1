 package com.manning.javapersistence.ch14.dao;

import com.manning.javapersistence.ch14.Bid;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Repository
@Transactional
public class BidDaoImpl implements BidDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Bid getById(long id) {
        return sessionFactory.getCurrentSession().get(Bid.class, id);
    }

    @Override
    public List<Bid> getAll() {
        return sessionFactory.getCurrentSession().createQuery("from Bid", Bid.class).list();
    }

    @Override
    public void insert(Bid bid) {
        sessionFactory.getCurrentSession().persist(bid);
    }

    @Override
    public void update(long id, String value) {
        Bid bid = sessionFactory.getCurrentSession().get(Bid.class, id);
        bid.setAmount(new BigDecimal(value));
        sessionFactory.getCurrentSession().update(bid);
    }

    @Override
    public void delete(Bid bid) {
        sessionFactory.getCurrentSession().delete(bid);
    }

    @Override
    public List<Bid> findByAmount(String value) {
        return sessionFactory.getCurrentSession().createQuery("from Bid where amount=:value", Bid.class)
                .setParameter("value", new BigDecimal(value)).list();
    }
}
