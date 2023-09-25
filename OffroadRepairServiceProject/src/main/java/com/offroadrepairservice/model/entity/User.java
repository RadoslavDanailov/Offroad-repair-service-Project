package com.offroadrepairservice.model.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table
public class User extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;


    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "users_parts",
            joinColumns = @JoinColumn(name = "fk_user"),
            inverseJoinColumns = @JoinColumn(name = "fk_part"))
    private Set<Part> cart;



    public User() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Part> getCart() {
        return cart;
    }

    public void setCart(Set<Part> myCart) {
        this.cart = myCart;
    }
    public void addPartToCart(Part part){
        this.cart.add(part);
    }

    public void removePartFromCart(Long partId){
        this.cart.removeIf(part -> part.getId().equals(partId));
    }

    public void deleteAllPartsFromCart(){
        this.cart.clear();
    }



}
