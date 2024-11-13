package org.imobiliaria.imobiliaria.models;

import jakarta.persistence.*;


import java.io.Serializable;

@Entity(name = "administrador")
public class AdministradorModel implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    int ID;
    @Column(name = "email")
    String email;

    @Column(name = "password")
    String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
