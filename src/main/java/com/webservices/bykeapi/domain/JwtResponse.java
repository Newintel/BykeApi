package com.webservices.bykeapi.domain;

import java.io.Serial;
import java.io.Serializable;

public class JwtResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = -8091879091924046844L;
    private final String token;

    public JwtResponse(String jwttoken) {
        this.token = jwttoken;
    }

    public String getToken() {
        return this.token;
    }
}