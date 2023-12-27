package com.example.dns.Models;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import java.util.List;


public class ProductCategory {


    private Long idProductCategory;
    @Size(min = 3, message = "The nameProductCategory cannot be less than 3 characters")
    @NotBlank(message = "NameProductCategory is required")
    private String nameProductCategory;

    private List<Product> products;

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

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
