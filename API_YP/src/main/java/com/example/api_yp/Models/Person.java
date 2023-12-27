package com.example.api_yp.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.util.List;
import java.util.Set;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idPerson;
    @Size(min = 3, max = 25, message = "The login cannot be less than 8 characters and more than 20 characters")
    @NotBlank(message = "Login is required")
    private String username;
    @Size(min = 8, message = "The password cannot be less than 8 characters")
    @Pattern(regexp = "^.*(?=.*[a-zA-Z])(?=.*\\d)(?=.*[!#$%&? \"]).*$" , message = "The password must contain uppercase and lowercase letters, numbers and special characters")
    @NotBlank(message = "Password is required")
    private String password;

    private boolean active;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "Role", joinColumns = @JoinColumn(name = "personId"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    public Person() {
    }

    public Person(Long idPerson, String username, String password, boolean active, Set<Role> roles) {
        this.idPerson = idPerson;
        this.username = username;
        this.password = password;
        this.active = active;
        this.roles = roles;
    }

    public Long getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(Long idPerson) {
        this.idPerson = idPerson;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
