package com.webservices.bykeapi.domain;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "excursion", schema = "byke")
public class Excursion {
    @EmbeddedId
    private ExcursionId id;

    @MapsId("userId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "pathId", nullable = false)
    private Path path;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bikeId")
    private Bike bike;

    @Column(name = "arrival")
    private Instant arrival;

    public ExcursionId getId() {
        return id;
    }

    public void setId(ExcursionId id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }

    public Bike getBike() {
        return bike;
    }

    public void setBike(Bike bike) {
        this.bike = bike;
    }

    public Instant getArrival() {
        return arrival;
    }

    public void setArrival(Instant arrival) {
        this.arrival = arrival;
    }

}