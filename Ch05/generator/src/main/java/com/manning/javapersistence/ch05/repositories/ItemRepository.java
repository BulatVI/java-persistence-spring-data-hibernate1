package com.manning.javapersistence.ch05.repositories;

import org.springframework.data.repository.CrudRepository;

import com.manning.javapersistence.ch05.model.Item;

public interface ItemRepository extends CrudRepository<Item, Long> {

}
