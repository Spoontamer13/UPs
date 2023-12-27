package com.example.autoitog.models;

import com.example.autoitog.service.Identifiable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class ModelBrand implements Identifiable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @NotBlank
    @Size(min = 1, max = 50)
    private String NameModel;

    @ManyToOne
    @JoinColumn(name = "Brand_ID")
    private Brand brand;

    public ModelBrand() {}

    public ModelBrand(int Id, String NameModel, Brand brand){
        this.Id = Id;
        this.NameModel = NameModel;
        this.brand = brand;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNameModel() {
        return NameModel;
    }

    public void setNameModel(String nameModel) {
        NameModel = nameModel;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }
}
