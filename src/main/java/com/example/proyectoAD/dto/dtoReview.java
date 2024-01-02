package com.example.proyectoAD.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class dtoReview {

    @NotNull(message = "Must send an opinion")
    @NotEmpty(message = "Must send an opinion")
    private String opinion;

    @NotNull(message = "Must send an score")
    private int score;

    @NotNull(message = "Must send a book id")
    private Long bookId;

    public dtoReview(String opinion, int score, Long bookId) {
        this.opinion = opinion;
        this.score = score;
        this.bookId = bookId;
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

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }
}
