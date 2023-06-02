package com.retoBackendend.equipo2.controllers;

import com.retoBackendend.equipo2.dto.AuthResponse;
import com.retoBackendend.equipo2.dto.LoginRequest;
import com.retoBackendend.equipo2.models.User;
import com.retoBackendend.equipo2.repositories.UserRepository;
import com.retoBackendend.equipo2.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/authorizations")
public class AuthController {


    private final UserRepository userRepository;

    @Autowired
    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest loginRequest) {
        User user = userRepository.findByEmailAndPassword(loginRequest.getEmail(), loginRequest.getPassword());
        if (user != null) {
            // Usuario autenticado correctamente
            String token = JwtUtil.generateToken(loginRequest.getEmail()); // Generar token de autenticación
            AuthResponse authResponse = new AuthResponse(token);
            return ResponseEntity.ok(authResponse);
        } else {
            // Autenticación fallida
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
