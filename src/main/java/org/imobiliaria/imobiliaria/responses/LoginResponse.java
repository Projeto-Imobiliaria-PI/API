package org.imobiliaria.imobiliaria.responses;

import java.io.Serializable;

public class LoginResponse implements Serializable {
    private String token;

    public LoginResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
