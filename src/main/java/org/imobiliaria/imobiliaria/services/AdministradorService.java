package org.imobiliaria.imobiliaria.services;

import org.imobiliaria.imobiliaria.dtos.LoginDto;
import org.imobiliaria.imobiliaria.models.AdministradorModel;
import org.imobiliaria.imobiliaria.repositories.AdministradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdministradorService {

    @Autowired
    private AdministradorRepository administradorRepository;

    public boolean authenticate(LoginDto loginDto) {
        Optional<AdministradorModel> adminOptional = administradorRepository.findByEmail(loginDto.getEmail());

        if (adminOptional.isPresent()) {
            AdministradorModel admin = adminOptional.get();
            return admin.getPassword().equals(loginDto.getPassword());
        }
        return false;
    }
}
