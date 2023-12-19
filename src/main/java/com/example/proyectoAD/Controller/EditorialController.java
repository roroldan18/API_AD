package com.example.proyectoAD.Controller;

import com.example.proyectoAD.Repository.EditorialRepository;
import com.example.proyectoAD.entity.Editorial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/editorial")
public class EditorialController {

    @Autowired
    private EditorialRepository editorialRepository;

    @GetMapping("/")
    public List<Editorial> getAllEditorials(){
        return editorialRepository.findAll();
    }


    @GetMapping("/name/{name}")
    public Optional<List<Editorial>> getEditorialByName(@PathVariable("name") String name){
        return editorialRepository.findByName(name);
    }


    @GetMapping("/{id}")
    public Editorial getEditorialById(@PathVariable("id") Long id){
        return editorialRepository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deleteEditorialById(@PathVariable("id") Long id){
        editorialRepository.deleteById(id);
    }

    @PostMapping("/")
    public Editorial createEditorial(@RequestBody Editorial editorial){
        return editorialRepository.save(editorial);
    }

    @PutMapping("/{id}")
    public Editorial updateEditorial(@PathVariable Long id, @RequestBody Editorial newEditorial){
        return editorialRepository.findById(id)
            .map(edit -> {
                edit.setName(newEditorial.getName());
                edit.setCountry(newEditorial.getCountry());
                return editorialRepository.save(edit);
            })
            .orElseGet(() -> {
                newEditorial.setIdEditorial(id);
                return editorialRepository.save(newEditorial);
            });
    }



}
