package com.retoBackendend.equipo2.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cuerpos")
public class Body {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @Lob
    private byte[] imagen;

    @Column(length = 1000)
    private String descripcion;

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

    //    @Id
//    @Column(name = "id")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(name = "nombre")
//    private String nombre;
//
//    @Column(name = "imagen")
//    private byte[] imagen;
//
//    @Column(name = "descripcion")
//    private String descripcion;
//
//
//
//    @OneToMany(mappedBy = "cuerpos", cascade = CascadeType.ALL, orphanRemoval = true)
//    @JsonIgnore
//    private List<Course> cursos  = new ArrayList<>();
//
//    public List<Course> getCursos() {
//        return cursos;
//    }
//
//    public void setCursos(List<Course> cursos) {
//        this.cursos = cursos;
//    }
//
//    public Body() {
//    }
//
//    public Body(Long id) {
//        this.id = id;
//    }
//
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
}


