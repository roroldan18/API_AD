package com.example.proyectoAD.Controller;

import com.example.proyectoAD.Repository.BookRepository;
import com.example.proyectoAD.Repository.ReviewRepository;
import com.example.proyectoAD.dto.dtoReview;
import com.example.proyectoAD.entity.Book;
import com.example.proyectoAD.entity.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review")
public class ReviewController {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/")
    public List<Review> getReviews(){
        return reviewRepository.findAll();
    }

    @GetMapping("/book/{id}")
    public List<Review> getReviewsByBookId(@PathVariable("id") Long id){
        return reviewRepository.findReviewsByBookId(id);
    }

    @GetMapping("{id}")
    public Review getReviewById(@PathVariable("id") Long id){
        return reviewRepository.findById(id).orElse(null);
    }

    @PostMapping("/")
    public Review postReview(@RequestBody dtoReview newReview){
        // Check if book exists
        Book book = bookRepository.findById(newReview.getBookId()).orElse(null);
        if (book == null) {
            throw new RuntimeException("El libro no existe");
        }

        Review review = new Review(newReview.getOpinion(), newReview.getScore(), book);
        return reviewRepository.save(review);
    }

    @PutMapping("/{id}")
    public Review putReview(@PathVariable("id") Long id, @RequestBody dtoReview newReview){
        Review review = reviewRepository.findById(id).orElse(null);
        if (review == null) {
            throw new RuntimeException("La reseña no existe");
        }

        // Check if book exists
        Book book = bookRepository.findById(newReview.getBookId()).orElse(null);
        if (book == null) {
            throw new RuntimeException("El libro no existe");
        }

        review.setOpinion(newReview.getOpinion());
        review.setScore(newReview.getScore());
        review.setBook(book);

        return reviewRepository.save(review);
    }

    @DeleteMapping("/{id}")
    public void deleteReviewById(@PathVariable("id") Long id){
        Review review = reviewRepository.findById(id).orElse(null);

        if (review == null) {
            throw new RuntimeException("La reseña no existe");
        } else{
            reviewRepository.delete(review);
        }
    }

}
