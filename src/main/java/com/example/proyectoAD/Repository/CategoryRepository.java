package com.example.proyectoAD.Repository;

import com.example.proyectoAD.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
