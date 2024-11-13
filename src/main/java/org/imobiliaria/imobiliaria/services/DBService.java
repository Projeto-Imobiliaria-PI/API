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

        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        VendedorModel vendedorModel1 = new VendedorModel("João", "12345678901", "Vendedor", formato.parse("09/09/2024"), false);
        VendedorModel vendedorModel2 = new VendedorModel("Bruno", "98765432100", "Corretor", formato.parse("16/09/2024"), true);
        VendedorModel vendedorModel3 = new VendedorModel("Teste", "11122233344", "TI", formato.parse("23/09/2024"), true);
        vendedorRepository.saveAll(Arrays.asList(vendedorModel1, vendedorModel2, vendedorModel3));
    }
}
