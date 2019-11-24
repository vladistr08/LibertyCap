package com.itec.app.Security.Services;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.itec.app.Entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class UserPrinciple implements UserDetails {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String streetNo;

    private String houseNo;

    private String postalCode;

    private String type;

    @JsonIgnore
    private String password;

    private Boolean hasConfirmed;

    private Collection<? extends GrantedAuthority> authorities;

    public UserPrinciple(Long id, String firstName, String lastName, String email, String streetNo, String houseNo, String postalCode, String type, String password, Boolean hasConfirmed, Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.streetNo = streetNo;
        this.houseNo = houseNo;
        this.postalCode = postalCode;
        this.type = type;
        this.password = password;
        this.hasConfirmed = hasConfirmed;
        this.authorities = authorities;
    }

    public static UserPrinciple build(User user) {
        List<GrantedAuthority> authorities = user.getRoles().stream().map(role ->
                new SimpleGrantedAuthority(role.getName().name())
        ).collect(Collectors.toList());

        return new UserPrinciple(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getStreetNo(),
                user.getHouseNo(),
                user.getPostalCode(),
                user.getType(),
                user.getPassword(),
                user.getHasConfirmed(),
                authorities
        );
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getStreetNo() {
        return streetNo;
    }

    public String getHouseNo() {
        return houseNo;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getType() {
        return type;
    }

    public Boolean getHasConfirmed() {
        return hasConfirmed;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserPrinciple user = (UserPrinciple) o;
        return Objects.equals(id, user.id);
    }
}
