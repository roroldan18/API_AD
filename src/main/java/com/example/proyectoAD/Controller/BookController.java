package com.example.proyectoAD.Controller;

import com.example.proyectoAD.Repository.BookRepository;
import com.example.proyectoAD.Repository.CategoryRepository;
import com.example.proyectoAD.Repository.EditorialRepository;
import com.example.proyectoAD.dto.dtoBook;
import com.example.proyectoAD.entity.Book;
import com.example.proyectoAD.entity.Category;
import com.example.proyectoAD.entity.Editorial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/libro")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private EditorialRepository editorialRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/")
    public List<Book> getBooks(){
        return bookRepository.findAll();
    }

    @GetMapping("/title/{title}")
    public List<Book> getBookByTitle(@PathVariable("title") String title){
        return bookRepository.findBooksByTitleContains(title);
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable("id") Long id){
        return bookRepository.findById(id).orElse(null);
    }

    @PostMapping("/")
    public Book createBook(@RequestBody dtoBook newBook){

        Category category = categoryRepository.findById(newBook.getCategoryId()).orElse(null);
        if (category == null) {
            throw new RuntimeException("La categoria no existe");
        }

        Editorial editorial = editorialRepository.findById(newBook.getEditorialId()).orElse(null);

        if (editorial == null) {
            throw new RuntimeException("La editorial no existe");
        }

        Book book = new Book(newBook.getTitle(), newBook.getAuthor(), newBook.getYear(), editorial, category);

        return bookRepository.save(book);
    }

    @DeleteMapping("/{id}")
    public void deleteBookById(@PathVariable("id") Long id){
        Book book = bookRepository.findById(id).orElse(null);

        if (book == null) {
            throw new RuntimeException("El libro no existe");
        } else{
            bookRepository.delete(book);
        }
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody dtoBook newBook){
        return bookRepository.findById(id)
            .map(book -> {
                book.setTitle(newBook.getTitle());
                book.setAuthor(newBook.getAuthor());
                book.setYear(newBook.getYear());
                book.setCategory(categoryRepository.findById(newBook.getCategoryId()).orElse(null));
                book.setEditorial(editorialRepository.findById(newBook.getEditorialId()).orElse(null));
                return bookRepository.save(book);
            })
            .orElseGet(() -> {
                Category category = categoryRepository.findById(newBook.getCategoryId()).orElse(null);
                Editorial editorial = editorialRepository.findById(newBook.getEditorialId()).orElse(null);
                Book createdBook = new Book(newBook.getTitle(), newBook.getAuthor(), newBook.getYear(), editorial, category);
                return bookRepository.save(createdBook);
            });
    }


}
