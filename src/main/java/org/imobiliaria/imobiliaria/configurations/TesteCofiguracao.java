package org.imobiliaria.imobiliaria.configurations;


import org.imobiliaria.imobiliaria.services.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.text.ParseException;

@Configuration
@Profile("test")
public class TesteCofiguracao {
    @Autowired
    DBService dbService;

    public boolean instantiateDatabase() throws ParseException {
        this.dbService.instanciaBaseDeDados();
        return true;
    }
}
