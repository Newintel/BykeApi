package com.webservices.bykeapi.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "user", schema = "byke")
@NamedQueries({
        @NamedQuery(name = "User.findByUsername", query = "select u from User u where u.username = ?1")
})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "username", nullable = false, length = 50)
    private String username;

    @Column(name = "lastname", length = 20)
    private String lastname;

    @Column(name = "firstname", length = 20)
    private String firstname;

    @Column(name = "password", length = 100)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @Column(name = "birthdate")
    private LocalDate birthdate;

    @Column(name = "size", precision = 6, scale = 2)
    private BigDecimal size;

    @Column(name = "weight", precision = 6, scale = 2)
    private BigDecimal weight;

    @OneToMany(mappedBy = "user")
    @JsonIgnoreProperties("user")
    private Set<Purchase> purchases = new LinkedHashSet<>();

    public Set<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(Set<Purchase> purchases) {
        this.purchases = purchases;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public BigDecimal getSize() {
        return size;
    }

    public void setSize(BigDecimal size) {
        this.size = size;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

}