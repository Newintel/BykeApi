package com.webservices.bykeapi.domain;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Embeddable
public class ExcursionId implements Serializable {
    @Serial
    private static final long serialVersionUID = 1765834235513986150L;
    @Column(name = "userId", nullable = false)
    private Integer userId;

    @Column(name = "departure", nullable = false)
    private Instant departure;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Instant getDeparture() {
        return departure;
    }

    public void setDeparture(Instant departure) {
        this.departure = departure;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ExcursionId entity = (ExcursionId) o;
        return Objects.equals(this.departure, entity.departure) &&
                Objects.equals(this.userId, entity.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departure, userId);
    }

}