package org.imobiliaria.imobiliaria.services;

import org.imobiliaria.imobiliaria.models.VendedorModel;
import org.imobiliaria.imobiliaria.repositories.AdministradorRepository;
import org.imobiliaria.imobiliaria.repositories.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private VendedorRepository vendedorRepository;
    @Autowired
    private AdministradorRepository administradorRepository;



    @Bean
    public void instanciaBaseDeDados() throws ParseException {

    }
}
