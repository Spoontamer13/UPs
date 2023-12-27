package com.example.api_yp.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
public class ProductCategory {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idProductCategory;
    @Size(min = 3, message = "The nameProductCategory cannot be less than 3 characters")
    @NotBlank(message = "NameProductCategory is required")
    private String nameProductCategory;

    public ProductCategory() {
    }

    public ProductCategory(Long idProductCategory, String nameProductCategory) {
        this.idProductCategory = idProductCategory;
        this.nameProductCategory = nameProductCategory;
    }

    public Long getIdProductCategory() {
        return idProductCategory;
    }

    public void setIdProductCategory(Long idProductCategory) {
        this.idProductCategory = idProductCategory;
    }

    public String getNameProductCategory() {
        return nameProductCategory;
    }

    public void setNameProductCategory(String nameProductCategory) {
        this.nameProductCategory = nameProductCategory;
    }
}
