package com.example.proyectoAD.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class dtoCategory {

    @NotNull(message = "Must send a name")
    @NotEmpty(message = "Must send a name")
    private String name;

    public dtoCategory(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
