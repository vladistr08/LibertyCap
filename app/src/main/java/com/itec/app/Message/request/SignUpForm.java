package com.itec.app.Message.request;

import org.hibernate.annotations.NaturalId;

import java.util.Set;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

public class SignUpForm {

    @NotBlank
    @Size(min=3, max = 50)
    private String firstName;

    @NotBlank
    @Size(min=3, max = 50)
    private String lastName;

    @NotBlank
    @Size(min=10, max = 50)
    private String phone;

    @NaturalId
    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @NotBlank
    @Size(min=3, max = 50)
    private String streetNo;

    @NotBlank
    @Size(min=3, max = 50)
    private String houseNo;

    @NotBlank
    @Size(min=3, max = 50)
    private String postalCode;

    @NotBlank
    @Size(min=3, max = 50)
    private String type;

    @NotBlank
    @Size(min=6, max = 100)
    private String password;

    private Set<String> role;

    @NotNull
    private String city;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStreetNo() {
        return streetNo;
    }

    public void setStreetNo(String streetNo) {
        this.streetNo = streetNo;
    }

    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<String> getRole() {
        return role;
    }

    public void setRole(Set<String> role) {
        this.role = role;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
