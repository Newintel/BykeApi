package com.webservices.bykeapi.domain;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

/**
 * A DTO for the {@link Excursion} entity
 */
public class ExcursionDto implements Serializable {
    private Instant departure;
    private Instant arrival;
    private Integer userId;
    private Integer pathId;
    private Integer bikeId;

    public ExcursionDto() {
    }

    public ExcursionDto(Instant departure, Integer userId, Integer pathId, Integer bikeId, Instant arrival) {
        this.departure = departure;
        this.userId = userId;
        this.pathId = pathId;
        this.bikeId = bikeId;
        this.arrival = arrival;
    }

    public Instant getDeparture() {
        return departure;
    }

    public void setDeparture(Instant departure) {
        this.departure = departure;
    }

    public Instant getArrival() {
        return arrival;
    }

    public void setArrival(Instant arrival) {
        this.arrival = arrival;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getPathId() {
        return pathId;
    }

    public void setPathId(Integer pathId) {
        this.pathId = pathId;
    }

    public Integer getBikeId() {
        return bikeId;
    }

    public void setBikeId(Integer bikeId) {
        this.bikeId = bikeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExcursionDto entity = (ExcursionDto) o;
        return Objects.equals(this.departure, entity.departure) &&
                Objects.equals(this.userId, entity.userId) &&
                Objects.equals(this.pathId, entity.pathId) &&
                Objects.equals(this.bikeId, entity.bikeId) &&
                Objects.equals(this.arrival, entity.arrival);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departure, userId, pathId, bikeId, arrival);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "departure = " + departure + ", " +
                "departure = " + arrival + ", " +
                "userId = " + userId + ", " +
                "pathId = " + pathId + ", " +
                "bikeId = " + bikeId + ")";
    }
}