package com.webservices.bykeapi.domain;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "bike", schema = "byke")
public class Bike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "brand", length = 20)
    private String brand;

    @Column(name = "wheels", precision = 6, scale = 2)
    private BigDecimal wheels;

    @Column(name = "cassette", length = 10)
    private String cassette;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public BigDecimal getWheels() {
        return wheels;
    }

    public void setWheels(BigDecimal wheels) {
        this.wheels = wheels;
    }

    public String getCassette() {
        return cassette;
    }

    public void setCassette(String cassette) {
        this.cassette = cassette;
    }

}