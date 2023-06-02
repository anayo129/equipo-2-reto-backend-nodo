package com.retoBackendend.equipo2.config;

public class NotFoundException extends RuntimeException {
    public NotFoundException(Long bodyId, String tipo) {
        super("No se encontró un " + tipo + " el ID: " + bodyId);
    }
}
