package org.imobiliaria.imobiliaria.controllers;

import org.imobiliaria.imobiliaria.dtos.LoginDto;
import org.imobiliaria.imobiliaria.responses.LoginResponse;
import org.imobiliaria.imobiliaria.services.AdministradorService;
import org.imobiliaria.imobiliaria.configurations.TokenGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@CrossOrigin(origins = "*", maxAge = 33600)
@RestController
@RequestMapping("/auth")
public class AdministradorController {



    @Autowired
    private AdministradorService administradorService;

    @Autowired
    private TokenGenerator tokenGenerator;


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDto loginDto) {


        boolean isAuthenticated = administradorService.authenticate(loginDto);

        if (isAuthenticated) {
            String token = tokenGenerator.generateToken(loginDto.getEmail());
            return ResponseEntity.ok().body(new LoginResponse(token));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas");
        }
    }
}

