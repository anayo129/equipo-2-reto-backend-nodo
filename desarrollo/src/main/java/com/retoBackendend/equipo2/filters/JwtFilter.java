package com.retoBackendend.equipo2.filters;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtFilter extends OncePerRequestFilter {
    private static final String AUTHORIZATION_HEADER = "Authorization";
    private static final String TOKEN_PREFIX = "Bearer ";
    private final String secretKey;
    public JwtFilter(String secretKey){this.secretKey = secretKey;}

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String requestURI = httpRequest.getRequestURI();

        //Excluir la ruta de inicio de sesión (/auth/login) del proceso de autorización
        //Excluir crear usuario
        if(requestURI.startsWith("/authorizations/login") || requestURI.startsWith("/users")){
            chain.doFilter(request, response);
            return;
        }
        try {
            String token = extractTokenFromHeader(request);
            if(token != null && validateToken(token)){
                chain.doFilter(request, response);
            } else {
                response.sendError(HttpStatus.UNAUTHORIZED.value());
            }
        } catch (JwtException e) {
            response.sendError(HttpStatus.UNAUTHORIZED.value());
        }
    }

    private String extractTokenFromHeader(HttpServletRequest request){
        String header = request.getHeader(AUTHORIZATION_HEADER);
        if(header != null && header.startsWith(TOKEN_PREFIX)){
            return  header.substring(TOKEN_PREFIX.length());
        }
        return  null;
    }

    private boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token);
            return true;
        } catch (JwtException e) {
            return false;
        }
    }
}
