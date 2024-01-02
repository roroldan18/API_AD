package com.example.proyectoAD.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class dtoEditorial {

    @NotNull(message = "Must send a name")
    @NotEmpty(message = "Must send a name")
    private String name;

    @NotNull(message = "Must send a country")
    @NotEmpty(message = "Must send a country")
    private String country;

    public dtoEditorial(String name, String country) {
        this.name = name;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
