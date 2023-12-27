package com.example.autoitog.models;

import com.example.autoitog.service.Identifiable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Users")
public class UserModel implements Identifiable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @NotBlank
    @Size(min = 8, max = 50)
    private String login;

    @NotBlank
    private String password;

    @ManyToOne
    @JoinColumn(name = "Role_ID")
    private Role role;

    public UserModel() {}

    public UserModel(int Id, String login, String password, Role role){
        this.Id = Id;
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
