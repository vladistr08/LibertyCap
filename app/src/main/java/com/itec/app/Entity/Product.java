package com.itec.app.Entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "email")
    private String email;

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "description")
    private String description;

    @NotNull
    @Column(name = "um")
    private String um;

    @NotNull
    @Column(name = "available_um")
    private Integer availableUm;

    @NotNull
    @Column(name = "price_um")
    private Double priceUm;

    @NotNull
    @Column(name = "subcategory_id")
    private Long subcategoryId;

    @NotNull
    @Column(name = "city")
    private String city;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUm() {
        return um;
    }

    public void setUm(String um) {
        this.um = um;
    }

    public Integer getAvailableUm() {
        return availableUm;
    }

    public void setAvailableUm(Integer availableUm) {
        this.availableUm = availableUm;
    }

    public Double getPriceUm() {
        return priceUm;
    }

    public void setPriceUm(Double priceUm) {
        this.priceUm = priceUm;
    }

    public Long getSubcategoryId() {
        return subcategoryId;
    }

    public void setSubcategoryId(Long subcategoryId) {
        this.subcategoryId = subcategoryId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

}
