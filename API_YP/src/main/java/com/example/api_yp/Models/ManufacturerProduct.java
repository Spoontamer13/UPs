package com.example.api_yp.Models;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
public class ManufacturerProduct {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idManufacturerProduct;
    @Size(min = 3, message = "The nameManufacturerProduct cannot be less than 3 characters")
    @NotBlank(message = "NameManufacturerProduct is required")
    private String nameManufacturerProduct;

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
}
