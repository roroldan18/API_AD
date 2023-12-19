package com.example.proyectoAD.Repository;

import com.example.proyectoAD.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
