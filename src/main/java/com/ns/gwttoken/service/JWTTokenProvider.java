package com.ns.gwttoken.service;

import com.ns.gwttoken.model.UserPrincipal;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Component
public class JWTTokenProvider {

    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value("${jwt.expirationInMs}")
    private int jwtExpirationInMs;

    public String generateToken(UserPrincipal userPrincipal){

        List<String> roles = userPrincipal
                .getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        return  Jwts.builder().setIssuer("Demo App")
                       .setIssuedAt(new Date())
                        .setExpiration(new Date(new Date().getTime() + jwtExpirationInMs))
                        .claim("Roles",roles)
                        .signWith(SignatureAlgorithm.HS512,jwtSecret).compact();
    }
}
