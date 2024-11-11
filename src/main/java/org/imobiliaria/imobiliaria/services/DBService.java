package org.imobiliaria.imobiliaria.services;

import org.imobiliaria.imobiliaria.entities.Vendedor;
import org.imobiliaria.imobiliaria.repositories.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@Service
public class DBService {
    @Autowired
    private VendedorRepository vendedorRepository;

    @Bean
    public void instanciaBaseDeDados() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Vendedor vendedor1 = new Vendedor("João", "12345678901", "Vendedor", LocalDate.parse("09/09/2024", formatter), false);
        Vendedor vendedor2 = new Vendedor("Bruno", "98765432100", "Corretor", LocalDate.parse("16/09/2024", formatter), true);
        Vendedor vendedor3 = new Vendedor("Teste", "11122233344", "TI", LocalDate.parse("23/09/2024", formatter), true);

        vendedorRepository.saveAll(Arrays.asList(vendedor1, vendedor2, vendedor3));
    }
}