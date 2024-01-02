package com.example.proyectoAD.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
public class dtoBook {

    @NotNull(message = "Must send a title")
    @NotBlank(message = "Must send a title")
    private String title;

    @NotNull(message = "Must send an author")
    @NotBlank(message = "Must send an author")
    private String author;

    @NotNull(message = "Must send a year")
    private int year;

    @NotNull(message = "Must send a category id")
    private Long categoryId;

    @NotNull(message = "Must send an editorial id")
    private Long editorialId;

    public dtoBook(String title, String author, int year, Long categoryId, Long editorialId) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.categoryId = categoryId;
        this.editorialId = editorialId;
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

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getEditorialId() {
        return editorialId;
    }

    public void setEditorialId(Long editorialId) {
        this.editorialId = editorialId;
    }
}
