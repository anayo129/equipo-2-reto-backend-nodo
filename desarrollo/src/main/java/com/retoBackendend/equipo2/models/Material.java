package com.retoBackendend.equipo2.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "material")
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String precio;

    @Column(length = 1000)
    private String descripcion;

    @Lob
    private byte[] imagen;

    @ManyToOne
    @JoinColumn(name = "id_curso")
    private Course curso;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    public Course getCurso() {
        return curso;
    }

    public void setCurso(Course curso) {
        this.curso = curso;
    }
//    @Id
//    @Column(name = "id")
//    @GeneratedValue( strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(name = "nombre")
//    private String nombre;
//
//    @Column(name = "precio")
//    private String precio;
//
//    @Column(name = "imagen")
//    private byte[] imagen;
//
//    @Column(name = "descripcion")
//    private String descripcion;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "id_curso")
//    @JsonBackReference
//    private Course id_curso;
//
//    public Material() {
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getNombre() {
//        return nombre;
//    }
//
//    public void setNombre(String nombre) {
//        this.nombre = nombre;
//    }
//
//    public String getPrecio() {
//        return precio;
//    }
//
//    public void setPrecio(String precio) {
//        this.precio = precio;
//    }
//
//    public byte[] getImagen() {
//        return imagen;
//    }
//
//    public void setImagen(byte[] imagen) {
//        this.imagen = imagen;
//    }
//
//    public String getDescripcion() {
//        return descripcion;
//    }
//
//    public void setDescripcion(String descripcion) {
//        this.descripcion = descripcion;
//    }
//
//    public Course getId_curso() {
//        return id_curso;
//    }
//
//    public void setId_curso(Course id_curso) {
//        this.id_curso = id_curso;
//    }
}
