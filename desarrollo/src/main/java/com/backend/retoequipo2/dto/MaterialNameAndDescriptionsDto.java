package com.backend.retoequipo2.dto;

public class MaterialNameAndDescriptionsDto {
    private String nombre;
    private String descripcion;

    public MaterialNameAndDescriptionsDto() {
        // Constructor vacío necesario para deserialización JSON
    }

    public MaterialNameAndDescriptionsDto(String nombre, String descripcion) {
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
