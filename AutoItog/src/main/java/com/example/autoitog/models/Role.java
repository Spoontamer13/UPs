package com.example.autoitog.models;

import com.example.autoitog.service.Identifiable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "Roles")
public class Role implements Identifiable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @NotBlank
    @Size(min = 1, max = 50)
    private String NameRole;

    public Role () {}

    public Role(int Id, String NameRole){
        this.Id = Id;
        this.NameRole = NameRole;
    }

    public Role(int Id, String NameRole, List<UserModel> userModel){
        this.Id = Id;
        this.NameRole = NameRole;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNameRole() {
        return NameRole;
    }

    public void setNameRole(String nameRole) {
        NameRole = nameRole;
    }
}
