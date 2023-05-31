package com.retoBackendend.equipo2.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "cursos")
public class Course {

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
    @JoinColumn(name = "id_cuerpo")
    private Body cuerpo;

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

    public Body getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(Body cuerpo) {
        this.cuerpo = cuerpo;
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
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "id_cuerpo", referencedColumnName = "id")
//    @JsonBackReference
//    private Body body;
//
//    @OneToMany(mappedBy = "id_curso")
//    @JsonIgnore
//    private List<Material> materials;
//
//
//
//    public Course() {
//    }
//
//    public Course(Long id) {
//        this.id = id;
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
//    public Body getBody() {
//        return body;
//    }
//
//    public void setBody(Body body) {
//        this.body = body;
//    }
//
//    public List<Material> getMaterials() {
//        return materials;
//    }
//
//    public void setMaterials(List<Material> materials) {
//        this.materials = materials;
//    }
}
