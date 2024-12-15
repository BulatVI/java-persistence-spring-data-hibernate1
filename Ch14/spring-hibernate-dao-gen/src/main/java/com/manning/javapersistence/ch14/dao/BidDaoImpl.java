 package com.manning.javapersistence.ch14.dao;

import com.manning.javapersistence.ch14.Bid;

public class BidDaoImpl extends AbstractGenericDao<Bid> {

    public BidDaoImpl() {
        setClazz(Bid.class);
    }

}
