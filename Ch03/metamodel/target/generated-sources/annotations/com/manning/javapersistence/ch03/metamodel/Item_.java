package com.manning.javapersistence.ch03.metamodel;

import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Item.class)
public abstract class Item_ {

	public static volatile SingularAttribute<Item, Date> auctionEnd;
	public static volatile SingularAttribute<Item, String> name;
	public static volatile SingularAttribute<Item, Long> id;

	public static final String AUCTION_END = "auctionEnd";
	public static final String NAME = "name";
	public static final String ID = "id";

}

