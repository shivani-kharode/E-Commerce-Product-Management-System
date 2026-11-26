package com.example.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

	private final String SECRET_KEY =
            "mySecretKeymySecretKeymySecretKey12345";

    public String generateToken(String email){

        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(
                        new Date(
                                System.currentTimeMillis()
                                + 86400000
                        ))
                .signWith(
                        Keys.hmacShaKeyFor(
                                SECRET_KEY.getBytes()
                        ),
                        SignatureAlgorithm.HS256
                )
                .compact();
    }
}