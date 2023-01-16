package com.webservices.bykeapi.domain;

import javax.persistence.*;

@Entity
@Table(name = "purchase", schema = "byke")
public class Purchase {
    @EmbeddedId
    private PurchaseId id;

    @MapsId("bikeId")
    @ManyToOne
    @JoinColumn(name = "bikeId", nullable = false)
    private Bike bike;

    @MapsId("userId")
    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    public PurchaseId getId() {
        return id;
    }

    public void setId(PurchaseId id) {
        this.id = id;
    }

    public Bike getBike() {
        return bike;
    }

    public void setBike(Bike bike) {
        this.bike = bike;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}