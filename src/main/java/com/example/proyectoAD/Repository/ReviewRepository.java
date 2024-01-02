package com.example.proyectoAD.Repository;

import com.example.proyectoAD.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findReviewsByBookId(Long id);


}
