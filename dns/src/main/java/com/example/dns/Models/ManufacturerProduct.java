package com.example.dns.Models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.List;

public class ManufacturerProduct {

    private Long idManufacturerProduct;

    @Size(min = 3, message = "The nameManufacturerProduct cannot be less than 3 characters")
    @NotBlank(message = "NameManufacturerProduct is required")
    private String nameManufacturerProduct;

    private List<Product> products;

    public ManufacturerProduct() {
    }

    public ManufacturerProduct(Long idManufacturerProduct, String nameManufacturerProduct) {
        this.idManufacturerProduct = idManufacturerProduct;
        this.nameManufacturerProduct = nameManufacturerProduct;
    }

    public Long getIdManufacturerProduct() {
        return idManufacturerProduct;
    }

    public void setIdManufacturerProduct(Long idManufacturerProduct) {
        this.idManufacturerProduct = idManufacturerProduct;
    }

    public String getNameManufacturerProduct() {
        return nameManufacturerProduct;
    }

    public void setNameManufacturerProduct(String nameManufacturerProduct) {
        this.nameManufacturerProduct = nameManufacturerProduct;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
