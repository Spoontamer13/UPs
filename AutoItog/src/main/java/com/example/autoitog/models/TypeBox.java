package com.example.autoitog.models;

import com.example.autoitog.service.Identifiable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "Type_Box")
public class TypeBox implements Identifiable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @NotBlank
    @Size(min = 1, max = 50)
    private String NameTypeBox;

    public TypeBox(){}
    public TypeBox(int Id, String NameTypeBox){
        this.Id = Id;
        this.NameTypeBox = NameTypeBox;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNameTypeBox() {
        return NameTypeBox;
    }

    public void setNameTypeBox(String nameTypeBox) {
        NameTypeBox = nameTypeBox;
    }
}
