package org.imobiliaria.imobiliaria.services;

import org.imobiliaria.imobiliaria.models.AdministradorModel;
import org.imobiliaria.imobiliaria.repositories.AdministradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;

@Component
public class InicializadorAdmin {

    @Autowired
    private AdministradorRepository administradorRepository;

    @PostConstruct
    public void init() {
        String defaultEmail = "a@a.com";
        String defaultPassword = "123";

        if (administradorRepository.findByEmail(defaultEmail).isEmpty()) {
            AdministradorModel admin = new AdministradorModel();
            admin.setEmail(defaultEmail);
            admin.setPassword(defaultPassword); // Em produção, faça hashing da senha
            administradorRepository.save(admin);
            System.out.println("Administrador criado com sucesso!");
        } else {
            System.out.println("Administrador já existe no sistema.");
        }
    }
}
