package com.example.proyectoAD.Repository;

import com.example.proyectoAD.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
