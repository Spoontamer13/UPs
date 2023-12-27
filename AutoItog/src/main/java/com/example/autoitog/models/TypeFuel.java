package com.example.autoitog.models;

import com.example.autoitog.service.Identifiable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "Type_Fuel")
public class TypeFuel implements Identifiable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @NotBlank
    @Size(min = 1, max = 50)
    private String NameTypeFuel;

    public TypeFuel(){}
    public TypeFuel(int Id, String NameTypeFuel){
        this.Id = Id;
        this.NameTypeFuel = NameTypeFuel;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNameTypeFuel() {
        return NameTypeFuel;
    }

    public void setNameTypeFuel(String nameTypeFuel) {
        NameTypeFuel = nameTypeFuel;
    }
}
