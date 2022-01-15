package com.example.jpaexample.io.spring.boot.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserRecord {
    @Id
    private Integer id;

    private String name;

    private String email;

    public UserRecord() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}