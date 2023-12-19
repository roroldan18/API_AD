package com.example.proyectoAD.Controller;

import com.example.proyectoAD.Repository.BookRepository;
import com.example.proyectoAD.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/libro")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/")
    public List<Book> getBooks(){
        return bookRepository.findAll();
    }

    @GetMapping("/name/{name}")
    public List<Book> getBookByName(@PathVariable("name") String name){
        return bookRepository.findByName(name);
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable("id") Long id){
        return bookRepository.findById(id).orElse(null);
    }

    @PostMapping("/")
    public Book createBook(@RequestBody Book book){
        return bookRepository.save(book);
    }

    @DeleteMapping("/{id}")
    public void deleteBookById(@PathVariable("id") Long id){
        bookRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book newBook){
        return bookRepository.findById(id)
            .map(book -> {
                book.setTitle(newBook.getTitle());
                book.setAuthor(newBook.getAuthor());
                book.setYear(newBook.getYear());
                return bookRepository.save(book);
            })
            .orElseGet(() -> {
                newBook.setId(id);
                return bookRepository.save(newBook);
            });
    }


}
