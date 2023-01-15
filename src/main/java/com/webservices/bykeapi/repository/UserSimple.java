package com.webservices.bykeapi.repository;

public class UserSimple {
    private int id;
    private String username;

    public UserSimple(int id, String username) {
        this.id = id;
        this.username = username;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
