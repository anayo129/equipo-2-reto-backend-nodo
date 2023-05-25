package com.backend.retoequipo2.dto;

public class MaterialRequestDto {

    private String nombre;
    private String precio;
    private byte[] imagen;
    private String descripcion;
    private Long id_curso;

    public MaterialRequestDto() {
        // Constructor vacío necesario para deserialización JSON
    }

    public MaterialRequestDto(String nombre, String precio, byte[] imagen, String descripcion, Long id_curso) {
        this.nombre = nombre;
        this.precio = precio;
        this.imagen = imagen;
        this.descripcion = descripcion;
        this.id_curso = id_curso;
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

    public Long getId_curso() {
        return id_curso;
    }

    public void setId_curso(Long id_curso) {
        this.id_curso = id_curso;
    }
}
