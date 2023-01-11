package com.webservices.bykeapi.domain;

import java.io.Serial;
import java.io.Serializable;

public class JwtResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = -8091879091924046844L;
    private final String token;
    private final int id;

    public JwtResponse(String jwttoken, int id) {
        this.token = jwttoken;
        this.id = id;
    }

    public String getToken() {
        return this.token;
    }

    public int getId() {
        return this.id;
    }
}