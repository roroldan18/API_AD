package com.example.proyectoAD.Repository;

import com.example.proyectoAD.entity.Book;
import com.example.proyectoAD.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByTitle(String title);
}
