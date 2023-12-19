package com.example.proyectoAD.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Resena")
public class Review {

    @Id
    @Column(name = "id_resena")
    private Long idReview;

    @Column(name = "opinion")
    private String opinion;

    @Column(name = "puntuacion")
    private int score;

    @OneToOne
    @JoinColumn(name = "id_libro")
    private Book book;

    public Review() {
    }

    public Review(Long idReview, String opinion, int score, Book book) {
        this.idReview = idReview;
        this.opinion = opinion;
        this.score = score;
        this.book = book;
    }

    public Long getIdReview() {
        return idReview;
    }

    public void setIdReview(Long idReview) {
        this.idReview = idReview;
    }

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
