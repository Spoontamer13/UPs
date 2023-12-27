package com.example.api_yp.Models;

import jakarta.persistence.*;

@Entity
public class PersonShop {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idPersonShop;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="personId", nullable=false)
    private Person person;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="productId", nullable=false)
    private Product product;

    public PersonShop() {
    }

    public PersonShop(Long idPersonShop, Person person, Product product) {
        this.idPersonShop = idPersonShop;
        this.person = person;
        this.product = product;
    }

    public Long getIdPersonShop() {
        return idPersonShop;
    }

    public void setIdPersonShop(Long idPersonShop) {
        this.idPersonShop = idPersonShop;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
