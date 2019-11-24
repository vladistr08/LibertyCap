package com.itec.app.Entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.NaturalId;

@Entity
@Table(name = "users")
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank
    @Size(min=3, max = 50)
    @Column(name = "first_name")
    private String firstName;

    @NotBlank
    @Size(min=3, max = 50)
    @Column(name = "last_name")
    private String lastName;

    @NotBlank
    @Size(min=10, max = 50)
    @Column(name = "phone")
    private String phone;

    @NaturalId
    @NotBlank
    @Size(max = 50)
    @Email
    @Column(name = "email")
    private String email;

    @NotBlank
    @Size(min=1, max = 50)
    @Column(name = "street_no")
    private String streetNo;

    @NotBlank
    @Size(min=1, max = 50)
    @Column(name = "house_no")
    private String houseNo;

    @NotBlank
    @Size(min=3, max = 50)
    @Column(name = "postal_code")
    private String postalCode;

    @NotBlank
    @Size(min=3, max = 50)
    @Column(name = "type")
    private String type;

    @NotBlank
    @Size(min=6, max = 100)
    @Column(name = "password")
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "role_user",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    @NotNull
    @Column(name = "city")
    private String city;

    @Column(name="has_confirmed")
    private Boolean hasConfirmed;

    public User() {}

    public User( @NotBlank @Size(min = 3, max = 50) String firstName, @NotBlank @Size(min = 3, max = 50) String lastName, @NotBlank @Size(min = 10, max = 50) String phone, @NotBlank @Size(max = 50) @Email String email, @NotBlank @Size(min = 3, max = 50) String streetNo, @NotBlank @Size(min = 3, max = 50) String houseNo, @NotBlank @Size(min = 3, max = 50) String postalCode, @NotBlank @Size(min = 3, max = 50) String type, @NotBlank @Size(min = 6, max = 100) String password, @NotNull String city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.streetNo = streetNo;
        this.houseNo = houseNo;
        this.postalCode = postalCode;
        this.type = type;
        this.password = password;
        this.city = city;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Boolean getHasConfirmed() {
        return hasConfirmed;
    }

    public void setHasConfirmed(Boolean hasConfirmed) {
        this.hasConfirmed = hasConfirmed;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
