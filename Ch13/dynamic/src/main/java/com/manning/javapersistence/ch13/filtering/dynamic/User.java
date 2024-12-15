 package com.manning.javapersistence.ch13.filtering.dynamic;

import com.manning.javapersistence.ch13.Constants;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue(generator = Constants.ID_GENERATOR)
    private Long id;

    @NotNull
    private String username;

    @NotNull
    private int ranking = 0;

    public User() {
    }

    public User(String username) {
        this.username = username;
    }

    public User(String username, int ranking) {
        this.username = username;
        this.ranking = ranking;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getRanking() {
        return ranking;
    }
}
