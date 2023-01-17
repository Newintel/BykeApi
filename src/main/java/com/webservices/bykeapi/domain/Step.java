package com.webservices.bykeapi.domain;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "step", schema = "byke")
public class Step {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "location", length = 25)
    private String location;

    @Column(name = "latitude", precision = 16, scale = 14)
    private BigDecimal latitude;

    @Column(name = "longitude", precision = 16, scale = 14)
    private BigDecimal longitude;

    @ManyToOne
    @JoinColumn(name = "creatorId")
    @JsonIncludeProperties({"id", "username"})
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private User creator;

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

}