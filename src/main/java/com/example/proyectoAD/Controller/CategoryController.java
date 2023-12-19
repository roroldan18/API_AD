package com.example.proyectoAD.Controller;

import com.example.proyectoAD.Repository.CategoryRepository;
import com.example.proyectoAD.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/")
    public List<Category> getCategories(){
        return categoryRepository.findAll();
    }

    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable("id") Long id){
        return categoryRepository.findById(id).orElse(null);
    }

    @GetMapping("/name/{name}")
    public List<Category> getCategoryByName(@PathVariable("name") String name){
        return categoryRepository.findByName(name);
    }

    @PostMapping("/")
    public Category createCategory(@RequestBody Category category){
        return categoryRepository.save(category);
    }

    @DeleteMapping("/{id}")
    public void deleteCategoryById(@PathVariable("id") Long id){
        categoryRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Category updateCategory(@PathVariable Long id, @RequestBody Category newCategory){
        return categoryRepository.findById(id)
            .map(category -> {
                category.setName(newCategory.getName());
                return categoryRepository.save(category);
            })
            .orElseGet(() -> {
                newCategory.setId(id);
                return categoryRepository.save(newCategory);
            });
    }



}
