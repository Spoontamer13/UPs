package com.example.autoitog.models;

import com.example.autoitog.service.Identifiable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Brand")
public class Brand implements Identifiable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @NotBlank
    @Size(min = 1, max = 50)
    private String NameBrand;

    public Brand() {}

    public Brand(int id, String NameBrand){
        this.Id = id;
        this.NameBrand = NameBrand;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public String getNameBrand() {
        return NameBrand;
    }

    public void setNameBrand(String nameBrand) {
        NameBrand = nameBrand;
    }
}
