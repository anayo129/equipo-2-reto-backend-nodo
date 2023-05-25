package com.backend.retoequipo2.dto;

public class CourseRequestDto {
    private String nombre;
    private String precio;
    private byte[] imagen;
    private String descripcion;
    private Long id_cuerpo;

    public CourseRequestDto() {
        // Constructor vacío necesario para deserialización JSON
    }

    public CourseRequestDto(String nombre, String precio, byte[] imagen, String descripcion, Long bodyId) {
        this.nombre = nombre;
        this.precio = precio;
        this.imagen = imagen;
        this.descripcion = descripcion;
        this.id_cuerpo = bodyId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
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

    public Long getId_cuerpo() {
        return id_cuerpo;
    }

    public void setId_cuerpo(Long id_cuerpo) {
        this.id_cuerpo = id_cuerpo;
    }
}
