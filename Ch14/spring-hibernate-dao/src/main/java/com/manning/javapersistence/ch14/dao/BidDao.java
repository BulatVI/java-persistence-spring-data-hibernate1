 package com.manning.javapersistence.ch14.dao;

import com.manning.javapersistence.ch14.Bid;

import java.util.List;

public interface BidDao {
    Bid getById(long id);

    List<Bid> getAll();

    void insert(Bid bid);

    void update(long id, String value);

    void delete(Bid bid);

    List<Bid> findByAmount(String value);
}