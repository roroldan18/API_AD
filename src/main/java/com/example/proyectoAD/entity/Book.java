package com.example.proyectoAD.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Libro")
public class Book {

    @Id
    @Column(name = "id_libro")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo")
    private String title;
    @Column(name = "autor")
    private String author;
    @Column(name = "anio_publicacion")
    private int year;

    @ManyToOne
    @JoinColumn(name = "id_editorial", foreignKey = @ForeignKey(name = "id_editorial"))
    private Editorial editorial;

    @ManyToOne
    @JoinColumn(name = "id_categoria", foreignKey = @ForeignKey(name = "id_editorial"))
    private Category category;

    public Book() {
    }

    public Book(String title, String author, int year, Editorial editorial, Category category) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.editorial = editorial;
        this.category = category;
    }

public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public Editorial getEditorial() {
        return editorial;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
