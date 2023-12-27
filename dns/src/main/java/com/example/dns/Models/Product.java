package com.example.dns.Models;



import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.List;


public class Product {

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
    private ManufacturerProduct manufacturerProduct;
    private ProductCategory productCategory;

    private List<Shop> shops;

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

    public List<Shop> getShops() {
        return shops;
    }

    public void setShops(List<Shop> shops) {
        this.shops = shops;
    }
}
