package com.webservices.bykeapi.domain;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Embeddable
public class PurchaseId implements Serializable {
    private static final long serialVersionUID = 818989064353673278L;
    @Column(name = "bikeId", nullable = false)
    private Integer bikeId;

    @Column(name = "userId", nullable = false)
    private Integer userId;

    @Column(name = "purchaseDate", nullable = false)
    private LocalDate purchaseDate;

    public Integer getBikeId() {
        return bikeId;
    }

    public void setBikeId(Integer bikeId) {
        this.bikeId = bikeId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PurchaseId entity = (PurchaseId) o;
        return Objects.equals(this.purchaseDate, entity.purchaseDate) &&
                Objects.equals(this.bikeId, entity.bikeId) &&
                Objects.equals(this.userId, entity.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(purchaseDate, bikeId, userId);
    }

}