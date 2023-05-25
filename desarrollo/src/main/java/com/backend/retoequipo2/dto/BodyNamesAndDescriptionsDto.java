package com.backend.retoequipo2.dto;

public class BodyNamesAndDescriptionsDto {

    private String nombre;
    private String descripcion;

    public BodyNamesAndDescriptionsDto() {
        // Constructor vacío necesario para deserialización JSON
    }

    public BodyNamesAndDescriptionsDto(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
