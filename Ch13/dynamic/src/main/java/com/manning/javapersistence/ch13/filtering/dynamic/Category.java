 package com.manning.javapersistence.ch13.filtering.dynamic;

import com.manning.javapersistence.ch13.Constants;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Category {

    @Id
    @GeneratedValue(generator = Constants.ID_GENERATOR)
    private Long id;

    @NotNull
    private String name;

    @OneToMany(mappedBy = "category")
    @org.hibernate.annotations.Filter(
            name = "limitByUserRanking",
            condition = """
                    :currentUserRanking >= (
                            select u.RANKING from USERS u
                            where u.ID = SELLER_ID
                            )"""
    )
    private Set<Item> items = new HashSet<>();

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Item> getItems() {
        return Collections.unmodifiableSet(items);
    }

}
