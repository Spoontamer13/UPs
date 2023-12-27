package com.example.dns.Models;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import java.util.List;


public class Shop {

    private Long idShop;
    @Size(min = 5, message = "The address cannot be less than 5 characters")
    @NotBlank(message = "Address is required")
    private String address;

    private Product product;

    private Schedule schedule;

    public Shop() {
    }

    public Shop(Long idShop, String address, Product product, Schedule schedule) {
        this.idShop = idShop;
        this.address = address;
        this.product = product;
        this.schedule = schedule;
    }

    public Long getIdShop() {
        return idShop;
    }

    public void setIdShop(Long idShop) {
        this.idShop = idShop;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

}
