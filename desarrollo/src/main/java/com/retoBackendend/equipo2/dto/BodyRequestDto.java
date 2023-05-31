package com.retoBackendend.equipo2.dto;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ByteArraySerializer;

public class BodyRequestDto {
    private String nombre;

//    @JsonDeserialize(using = ByteArrayDeserializer.class)
    private byte[] imagen;
    private String descripcion;

    public BodyRequestDto() {
        // Constructor vacío necesario para deserialización JSON
    }

    public BodyRequestDto(String nombre, byte[] imagen, String descripcion) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
