package org.imobiliaria.imobiliaria.configurations;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;


import java.util.Date;
import java.security.Key;
@Component
public class TokenGenerator {

    private Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256); // Gera uma chave secreta automaticamente

    public String generateToken(String email) {
        long expirationTime = 3600000; // Tempo de expiração em milissegundos (1 hora)

        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
                .signWith(key)
                .compact();
    }
}