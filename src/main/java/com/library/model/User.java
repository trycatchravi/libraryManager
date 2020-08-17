package com.library.model;

import javax.persistence.*;

@Entity
@Table(name = "book")
public class User {

    @Id
    @GeneratedValue
    int id;

    @Column(name = "username")
    String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
