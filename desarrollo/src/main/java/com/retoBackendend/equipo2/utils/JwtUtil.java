package com.retoBackendend.equipo2.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Date;

public class JwtUtil {
    //clave secreta para firmar y veridicar el token
    public static  final SecretKey SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    //duración del token en milisegundos
    public static final long EXPIRATION_TIME = 3_600_000;

    //Generar un nuevo token JWT

    public static String generateToken(String username){
        Date now = new Date();
        Date expirationDate = new Date(now.getTime() + EXPIRATION_TIME);

        return Jwts.builder().
                setSubject(username).
                setIssuedAt(now).
                setExpiration(expirationDate).
                signWith(SECRET_KEY).
                compact();
    }

    //Verificar y obtener los dtos del token
    public static String getUsernameFromToken(String token){
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY)
                .build()
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }
}
