package com.agendaatlas.shared;

import java.util.Base64;

import javax.crypto.SecretKey;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

public class JwtKeyGenerator {

    public static void main(String[] args) {
        // Gera uma chave segura para o algoritmo HS256
        SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

        // Converte para uma string Base64 (para armazenar no application.properties ou
        // env var)
        String encodedKey = Base64.getEncoder().encodeToString(key.getEncoded());

        System.out.println("Chave secreta gerada:");
        System.out.println(encodedKey);
    }

}
