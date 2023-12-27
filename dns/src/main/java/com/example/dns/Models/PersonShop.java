package com.example.dns.Models;

public class PersonShop {

    private Long idPersonShop;
    private Person person;

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
