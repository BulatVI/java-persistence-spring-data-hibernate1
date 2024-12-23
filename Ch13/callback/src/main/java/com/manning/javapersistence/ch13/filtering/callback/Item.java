 package com.manning.javapersistence.ch13.filtering.callback;

import com.manning.javapersistence.ch13.Constants;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@EntityListeners(
        PersistEntityListener.class
)
@ExcludeDefaultListeners
public class Item {

    @Id
    @GeneratedValue(generator = Constants.ID_GENERATOR)
    private Long id;

    @NotNull
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SELLER_ID", nullable = false)
    private User seller;

    public Item() {
    }

    public Item(String name, User seller) {
        this.name = name;
        this.seller = seller;
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

    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }
}
