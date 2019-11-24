package com.itec.app.Dto;



import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

public class ProductDto implements Comparable<ProductDto>{

    private String email;

    private String name;

    private String description;

    private String um;

    private String availableUm;

    private String priceUm;

    private Long subcategoryId;

    private String city;

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

    public String getAvailableUm() {
        return availableUm;
    }

    public void setAvailableUm(String availableUm) {
        this.availableUm = availableUm;
    }

    public String getPriceUm() {
        return priceUm;
    }

    public void setPriceUm(String priceUm) {
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

    @Override
    public int compareTo(ProductDto u) {
        if (getPriceUm() == null || u.getPriceUm() == null) {
            return 0;
        }
        return getPriceUm().compareTo(u.getPriceUm());
    }
}
