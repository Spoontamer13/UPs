package com.example.api_yp.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idProduct;
    @Size(min = 3, message = "The name cannot be less than 8 characters and more than 20 characters")
    @NotBlank(message = "Name is required")
    private String name;
    @Size(min = 10, message = "The specifications cannot be less than 8 characters and more than 20 characters")
    @NotBlank(message = "Specifications is required")
    private String specifications;

    @Size(min = 10, message = "The description cannot be less than 8 characters and more than 20 characters")
    @NotBlank(message = "Description is required")
    private String description;
    @NotNull
    private Double price;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="manufacturerProductId", nullable=false)
    private ManufacturerProduct manufacturerProduct;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="productCategoryId", nullable=false)
    private ProductCategory productCategory;

    public Product() {
    }

    public Product(Long idProduct, String name, String specifications, String description, Double price, ManufacturerProduct manufacturerProduct, ProductCategory productCategory) {
        this.idProduct = idProduct;
        this.name = name;
        this.specifications = specifications;
        this.description = description;
        this.price = price;
        this.manufacturerProduct = manufacturerProduct;
        this.productCategory = productCategory;
    }




    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public ManufacturerProduct getManufacturerProduct() {
        return manufacturerProduct;
    }

    public void setManufacturerProduct(ManufacturerProduct manufacturerProduct) {
        this.manufacturerProduct = manufacturerProduct;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }
}
