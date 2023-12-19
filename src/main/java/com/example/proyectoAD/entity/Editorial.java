package com.example.proyectoAD.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Editorial")
public class Editorial {
    @Id
    @Column(name = "id_editorial")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEditorial;

    @Column(name = "nombre")
    private String name;

    @Column(name = "pais")
    private String country;

    public Editorial() {
    }

    public Editorial(String name, String country) {
        this.name = name;
        this.country = country;
    }

    public Editorial(Long idEditorial, String name, String country) {
        this.idEditorial = idEditorial;
        this.name = name;
        this.country = country;
    }

    public Long getIdEditorial() {
        return idEditorial;
    }

    public void setIdEditorial(Long idEditorial) {
        this.idEditorial = idEditorial;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
