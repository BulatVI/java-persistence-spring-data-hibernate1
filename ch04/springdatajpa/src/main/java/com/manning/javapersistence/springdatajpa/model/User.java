package com.manning.javapersistence.springdatajpa.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String username;

    private LocalDate registrationDate;

    public User() {
    }

    public User(String username) {
        this.username = username;
    }

    public User(String username, LocalDate registrationDate) {
        this.username = username;
        this.registrationDate = registrationDate;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username +
                ", registrationDate=" + registrationDate + "]";
    }

}
