package com.example.autoitog.models;

import com.example.autoitog.service.Identifiable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "Type_Drive")
public class TypeDrive implements Identifiable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @NotBlank
    @Size(min = 1, max = 50)
    private String NameTypeDrive;

    @OneToMany(mappedBy = "typeDrive", cascade = CascadeType.ALL)
    private List<Car> car;

    public TypeDrive(){}
    public TypeDrive(int Id, String NameTypeDrive, List<Car> car){
        this.Id = Id;
        this.NameTypeDrive = NameTypeDrive;
        this.car = car;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNameTypeDrive() {
        return NameTypeDrive;
    }

    public void setNameTypeDrive(String nameTypeDrive) {
        NameTypeDrive = nameTypeDrive;
    }

    public List<Car> getCar() {
        return car;
    }

    public void setCar(List<Car> car) {
        this.car = car;
    }
}
