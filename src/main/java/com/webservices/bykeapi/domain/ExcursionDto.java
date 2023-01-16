package com.webservices.bykeapi.domain;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

/**
 * A DTO for the {@link Excursion} entity
 */
public class ExcursionDto implements Serializable {
    private final Instant arrival;

    public ExcursionDto(Instant arrival) {
        this.arrival = arrival;
    }

    public Instant getArrival() {
        return arrival;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExcursionDto entity = (ExcursionDto) o;
        return Objects.equals(this.arrival, entity.arrival);
    }

    @Override
    public int hashCode() {
        return Objects.hash(arrival);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "arrival = " + arrival + ")";
    }
}