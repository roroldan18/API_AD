package com.example.proyectoAD.Repository;

import com.example.proyectoAD.entity.Editorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EditorialRepository extends JpaRepository<Editorial, Long>{
    List<Editorial> findByName(String name);

}
